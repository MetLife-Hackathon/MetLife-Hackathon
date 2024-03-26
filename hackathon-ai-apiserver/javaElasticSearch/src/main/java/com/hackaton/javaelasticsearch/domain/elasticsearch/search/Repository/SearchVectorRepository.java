package com.hackaton.javaelasticsearch.domain.elasticsearch.search.Repository;

import com.hackaton.javaelasticsearch.domain.elasticsearch.search.model.SearchVectorRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchVectorRepository extends ElasticsearchRepository<SearchVectorRequest, String> {
}