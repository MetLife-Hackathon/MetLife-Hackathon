package com.hackaton.javaelasticsearch.domain.gpt.search.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateEmbeddingResponse {
    private String model;
    private UsageInfoDTO usage;
    private List<EmbeddingInfoDTO> data;
}
