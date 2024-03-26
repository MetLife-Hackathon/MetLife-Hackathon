package com.hackaton.javaelasticsearch.domain.gpt.search.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmbeddingInfoDTO {
    private int index;
    private List<Float> embedding;
}
