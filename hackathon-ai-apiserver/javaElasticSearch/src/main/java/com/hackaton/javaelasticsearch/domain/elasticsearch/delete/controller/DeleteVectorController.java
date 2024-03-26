package com.hackaton.javaelasticsearch.domain.elasticsearch.delete.controller;

import com.hackaton.javaelasticsearch.domain.elasticsearch.delete.service.DeleteVectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DeleteVectorController {
    private final DeleteVectorService deleteVectorService;

    @Autowired
    public DeleteVectorController(DeleteVectorService deleteVectorService) {
        this.deleteVectorService = deleteVectorService;
    }

    @DeleteMapping("/delete/vectors")
    public ResponseEntity<?> deleteAllTextVectors() {
        try {
            deleteVectorService.deleteAllTextVectors();
            return ResponseEntity.ok().body("All text vectors have been deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting text vectors: " + e.getMessage());
        }
    }
}
