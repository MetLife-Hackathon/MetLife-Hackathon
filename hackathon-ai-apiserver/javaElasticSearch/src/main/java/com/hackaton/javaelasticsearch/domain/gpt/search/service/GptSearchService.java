package com.hackaton.javaelasticsearch.domain.gpt.search.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.javaelasticsearch.domain.gpt.search.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
@Service
public class GptSearchService {
    private final WebClient webClient;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper;

    @Value("${chatgpt.apiKey}")
    private String apiKey;

    public GptSearchService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com").build();
        this.objectMapper = objectMapper;
    }

    public String getGpt4_1106_previewResponse_Text(String prompt) {
        List<Gpt4_1106_previewRequest.Message> messages = new ArrayList<>();
        messages.add(new Gpt4_1106_previewRequest.Message("user", prompt));
        Gpt4_1106_previewRequest request = new Gpt4_1106_previewRequest(
            "gpt-4-1106-preview",
            messages,
            0.8f
        );
        try {
            Gpt4_1106_previewResponse response = webClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Gpt4_1106_previewResponse.class)
                .blockOptional()
                .orElseThrow(() -> new IllegalStateException("Error occurred while completing chat"));
            return response.getChoices().get(0).getMessage().getContent();
        } catch (WebClientResponseException e) {
            log.error("Error occurred while completing chat - " + e.getResponseBodyAsString(), e);
            throw new IllegalStateException("Error occurred while completing chat", e);
        }
    }

    public Float[] createEmbeddings(CreateEmbeddingRequest createEmbeddingRequest) {
        try {
            CreateEmbeddingResponse createEmbeddingResponse = webClient.post()
                .uri("/v1/embeddings")
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(createEmbeddingRequest)
                .retrieve()
                .bodyToMono(CreateEmbeddingResponse.class)
                .blockOptional()
                .orElseThrow(
                    () -> new IllegalStateException("Error occurred while creating embeddings"));
            return createEmbeddingResponse.getData()
                    .stream().map(EmbeddingInfoDTO::getEmbedding)
                    .collect(Collectors.toList()).get(0).stream().toArray(Float[]::new);
        } catch (WebClientResponseException e) {
            log.error("Error occurred while completing chat - " + e.getResponseBodyAsString(), e);
            throw new IllegalStateException("Error occurred while completing chat", e);
        }
    }
}
