package com.hackaton.javaelasticsearch.domain.elasticsearch.post.repository;

import com.hackaton.javaelasticsearch.domain.elasticsearch.post.model.PostVector;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostVectorRepository extends ElasticsearchRepository<PostVector, String> {
}