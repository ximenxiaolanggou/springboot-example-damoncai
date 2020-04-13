package com.ximen.springbootelasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhishun.cai
 * @date 2020/3/17 20:53
 * @note
 */
@Document(indexName = "people_index",type = "people_type",shards = 1,replicas = 1)
public class People {

    @Id
    private String id;

    // 整个name不被分词，切不创建索引
    // Keyword表示不被分词
    @Field(type= FieldType.Keyword,index = false)
    private String name;

    // address被ik分词
    // Text类型的属性才能被分词
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String address;

    @Field(type = FieldType.Long,index = false)
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public People(){}

    public People(String id, String name, String address, Integer age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
