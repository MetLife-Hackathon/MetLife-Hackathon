package com.hackaton.javaelasticsearch.domain.elasticsearch.post.service;

import com.hackaton.javaelasticsearch.domain.elasticsearch.post.repository.PostVectorRepository;
import com.hackaton.javaelasticsearch.domain.elasticsearch.post.model.PostVector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostVectorService {

    private final PostVectorRepository repository;

    @Autowired
    public PostVectorService(PostVectorRepository repository) {
        this.repository = repository;
    }

    public PostVector saveTextVector(PostVector postVector) {
        return repository.save(postVector);
    }

}
