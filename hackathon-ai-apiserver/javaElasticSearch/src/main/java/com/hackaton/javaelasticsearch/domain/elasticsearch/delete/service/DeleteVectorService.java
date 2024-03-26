package com.hackaton.javaelasticsearch.domain.elasticsearch.delete.service;

import com.hackaton.javaelasticsearch.domain.elasticsearch.delete.repository.DeleteVectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteVectorService {

    private final DeleteVectorRepository repository;

    @Autowired
    public DeleteVectorService(DeleteVectorRepository repository) {
        this.repository = repository;
    }

    public void deleteAllTextVectors() {
        repository.deleteAll();
    }

}
