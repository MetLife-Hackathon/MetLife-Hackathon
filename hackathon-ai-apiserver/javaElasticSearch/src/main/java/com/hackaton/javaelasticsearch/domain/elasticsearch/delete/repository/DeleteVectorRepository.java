package com.hackaton.javaelasticsearch.domain.elasticsearch.delete.repository;

import com.hackaton.javaelasticsearch.domain.elasticsearch.delete.model.DeleteVector;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DeleteVectorRepository extends ElasticsearchRepository<DeleteVector, String> {
}