package com.pj.elasticSearch.service.impl;

import com.pj.elasticSearch.entity.BlogModel;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/***
 * 实现
 * @author cc
 */
public interface BlogRepository extends ElasticsearchRepository<BlogModel, String> {

    List<BlogModel> findByTitleLike(Object keyword);
    List<BlogModel> findByTime(Object keyword);

    @Query("{\"match_phrase\":{\"title\":\"?0\"}}")
    List<BlogModel> getQuery(Object keyword);


}