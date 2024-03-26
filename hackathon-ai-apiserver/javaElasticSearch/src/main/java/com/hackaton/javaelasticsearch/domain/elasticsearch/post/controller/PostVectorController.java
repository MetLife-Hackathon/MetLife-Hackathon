package com.hackaton.javaelasticsearch.domain.elasticsearch.post.controller;

import com.hackaton.javaelasticsearch.domain.elasticsearch.post.model.PostVector;
import com.hackaton.javaelasticsearch.domain.elasticsearch.post.service.PostVectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostVectorController {

    private final PostVectorService postVectorService;

    @Autowired
    public PostVectorController(PostVectorService postVectorService) {
        this.postVectorService = postVectorService;
    }

    @PostMapping("/post/vectors")
    public ResponseEntity<?> saveTextVector(@RequestBody PostVector postVector) {
        try {
            PostVector savedPostVector = postVectorService.saveTextVector(postVector);
            return ResponseEntity.ok().body("Text vector saved with ID: " + savedPostVector.getId());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error saving text vector: " + e.getMessage());
        }
    }
}
