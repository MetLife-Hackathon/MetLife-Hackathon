package com.hackaton.javaelasticsearch.domain.gpt.search.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsageInfoDTO {
    private int promptTokens;
    private int totalTokens;
}