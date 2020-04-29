package com.ximen.springbootelasticsearch;

import com.ximen.springbootelasticsearch.dao.PeopleMapper;
import com.ximen.springbootelasticsearch.entity.People;
import org.elasticsearch.index.query.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import javax.management.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootElasticsearchApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    void createIndex() {
        elasticsearchTemplate.createIndex(People.class);
        elasticsearchTemplate.putMapping(People.class);
    }

    @Test
    void deleteIndex(){
        boolean res = elasticsearchTemplate.deleteIndex(People.class);
        System.out.println(res);
    }

    @Test
    void insert(){
        People people = new People();
        people.setId("1");
        people.setName("张三");
        people.setAddress("上海市");
        people.setAge(10);

        IndexQuery query = new IndexQuery();
        query.setObject(people);
        String res = elasticsearchTemplate.index(query);
        System.out.println(res);
    }

    @Test
    void insertBulk(){
        List<IndexQuery> list = Arrays.asList(
                new IndexQueryBuilder().withObject(new People("2","李四",null,13)).build(),
                new IndexQueryBuilder().withObject(new People("3","王五","南京",12)).build(),
                new IndexQueryBuilder().withObject(new People("4","武松","东京",11)).build(),
                new IndexQueryBuilder().withObject(new People("5","送哥","戏精",10)).build()
        );
        elasticsearchTemplate.bulkIndex(list);
    }

    @Test
    void deleteDoc(){
        String res = elasticsearchTemplate.delete(People.class, "1");
        System.out.println(res);
    }

    @Test
    void query(){
        // NativeSearchQuery构造方法参数。
        // 京去和所有field进行匹配，只要出现了北京就可以进行查询
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery("京");
        // 查询条件SearchQuery是接口，只能实例化实现类。
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    @Test
    void mathAll(){
        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    @Test
    void  math(){
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("address","我要去南京");
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    /**
     * 短语搜索: 对条件不分词 ，但是文档属性根据配置实体类时指定的分词类型进行分词
     */
    @Test
    void  mathPhrase(){
        MatchPhraseQueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("address","我要去南京");
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    @Test
    void  range(){
        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("age").gte(11).lte(13);
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    @Test
    void  mustShould(){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<QueryBuilder> list = new ArrayList<>();
        list.add(QueryBuilders.matchPhraseQuery("address","我要去南京"));
        list.add(QueryBuilders.rangeQuery("age").gte(11).lte(13));
        boolQueryBuilder.must().addAll(list);
        SearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    @Test
    void  pageSort(){
        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        searchQuery.setPageable(PageRequest.of(0,2));
        searchQuery.addSort(Sort.by(Sort.Direction.DESC,"age"));
        List<People> people = elasticsearchTemplate.queryForList(searchQuery, People.class);
        for (People person : people) {
            System.out.println(person);
        }
    }

    @Autowired
    private PeopleMapper peopleMapper;

    @Test
    public void test(){
//        Iterable<People> all = peopleMapper.findAll();
//        for (People people : all) {
//            System.out.println(people);
//        }
        List<People> list = peopleMapper.findByAddressLike("%京%");
        for (People people : list) {
            System.out.println(people);
        }
    }
}
