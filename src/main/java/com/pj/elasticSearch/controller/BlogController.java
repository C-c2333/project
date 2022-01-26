package com.pj.elasticSearch.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import com.pj.elasticSearch.entity.BlogModel;
import com.pj.elasticSearch.service.impl.BlogRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RegexpQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostMapping("/add")
    public JSONObject add(@RequestBody BlogModel blogModel) {
        BlogModel save = blogRepository.save(blogModel);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("S", save);
        return jsonObject;
    }

    @GetMapping("/get/{id}")
    public JSONObject getById(@PathVariable Integer id) {
        JSONObject jsonObject = new JSONObject();

        // Optional<BlogModel> blogModelOptional = blogRepository.findById(id);
      /*  if (blogModelOptional.isPresent()) {
            BlogModel blogModel = blogModelOptional.get();
            jsonObject.put("S", blogModel);

            return jsonObject;
        }*/
        return jsonObject;
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        blogRepository.deleteAll();
    }

    @GetMapping("/findByTitleLike")
    public JSONObject findByTitleLike(@RequestParam Map map) {
        Object keyword = map.get("keyword");
        Object time = map.get("time");
        JSONObject jsonObject = new JSONObject();
        List<BlogModel> byTitleLike = blogRepository.findByTitleLike(keyword);
        List<BlogModel> findByTime = blogRepository.findByTime(time);
        List<BlogModel> get = blogRepository.getQuery(keyword);


        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("title", keyword));

        ArrayList<String> objects = new ArrayList<>();
        objects.add("YWVWw3sBW6ovDTlxYhGM");
        Pageable pageable = PageRequest.of(0, 2);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(pageable)
                .build();
        List<BlogModel> searchQueryList = elasticsearchTemplate.queryForList(searchQuery, BlogModel.class);

        jsonObject.put("byTitleLike", byTitleLike);
        jsonObject.put("findByTime", findByTime);
        jsonObject.put("get", get);
        jsonObject.put("searchQueryList", searchQueryList);
        return jsonObject;
    }

    @GetMapping("/boolQueryBuilder")
    public JSONObject boolQueryBuilder(@RequestParam Map map) {

        Object keyword = map.get("keyword");
        Object time = map.get("time");
        JSONObject jsonObject = new JSONObject();

        // 精确查找
        // ElasticSearchTemplate加中文筛选后无结果的解决办法：title.keyword
        String field = "title.keyword";
        String timeField = "time.time";
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(QueryBuilders.termsQuery(field, keyword));
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(PageRequest.of(0, 100))
                .build();
        List<BlogModel> searchQueryList =
                elasticsearchTemplate.queryForList(searchQuery, BlogModel.class);

        jsonObject.put("searchQuery", searchQueryList);

        FieldSortBuilder ageSortBuilder = SortBuilders.fieldSort("time").order(SortOrder.ASC);

        boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(QueryBuilders.wildcardQuery(field, "*" + keyword + "*"));

        // 不加过滤条件以前，返回所有查询keyword匹配的数据
        // 加了过滤条件"小"，返回结果："小"，剔除了所有不符合的数据
        BoolQueryBuilder filter = QueryBuilders.boolQuery();
        filter.should(QueryBuilders.termsQuery(field, "小米", "小"));
        searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(PageRequest.of(0, 100))
                // 限制条件
                .withFilter(filter)
                .withSort(ageSortBuilder)
                .build();

        List<BlogModel> list =
                elasticsearchTemplate.queryForList(searchQuery, BlogModel.class);

        jsonObject.put("withFilter", list);

        return jsonObject;
    }


}