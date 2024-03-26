package com.hackaton.javaelasticsearch.domain.gpt.search.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Data;
import lombok.Getter;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class Gpt4_1106_previewResponse {
    public String id;
    public String object;
    public long created;
    public String model;
    public Usage usage;
    public List<Choice> choices;
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Getter
    public static class Usage {
        public int promptTokens;
        public int completionTokens;
        public int totalTokens;
    }
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Getter
    public static class Choice {
        public Message message;
        public String finishReason;
        public int index;
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @Data
        public static class Message {
            public String role;
            public String content;
        }
    }
}
