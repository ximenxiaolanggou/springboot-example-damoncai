package com.ximen.springbootelasticsearch.dao;

import com.ximen.springbootelasticsearch.entity.People;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2020/3/17 22:22
 * @note
 */
public interface PeopleMapper extends ElasticsearchRepository<People,String> {
    List<People> findByAddressLike(String address);
    List<People> findByAddress(String address);
}
