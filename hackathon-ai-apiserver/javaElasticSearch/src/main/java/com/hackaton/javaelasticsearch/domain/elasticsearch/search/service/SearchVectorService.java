package com.hackaton.javaelasticsearch.domain.elasticsearch.search.service;

import com.hackaton.javaelasticsearch.domain.elasticsearch.search.model.SearchVectorRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.hackaton.javaelasticsearch.domain.elasticsearch.search.model.SearchVectorRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;

import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
@Service
public class SearchVectorService {

    private final ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public SearchVectorService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public SearchHits<SearchVectorRequest> findBySimilarity(float[] vector, float minSimilarity) {

        System.out.println(Arrays.toString(vector));

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.scriptScoreQuery(
                        QueryBuilders.matchAllQuery(),
                        new org.elasticsearch.script.Script(
                                org.elasticsearch.script.ScriptType.INLINE,
                                "painless",
                                "cosineSimilarity(params.queryVector, 'embeddings') + 1.0",
                                Collections.singletonMap("queryVector", vector)
                        )
                )).withMinScore(minSimilarity)
                .build();

        return elasticsearchOperations.search(searchQuery, SearchVectorRequest.class);
    }
}

