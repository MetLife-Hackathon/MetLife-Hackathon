package com.hackaton.javaelasticsearch.domain.gpt.search.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEmbeddingRequest {
    private String input;
    private String model;
}
