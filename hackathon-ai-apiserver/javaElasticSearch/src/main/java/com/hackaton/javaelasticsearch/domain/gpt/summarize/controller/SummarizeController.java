package com.hackaton.javaelasticsearch.domain.gpt.summarize.controller;

import com.hackaton.javaelasticsearch.domain.gpt.search.service.GptSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/summarize")
public class SummarizeController {

    private final GptSearchService gptClient_gpt4_1106_preview;

    @PostMapping
    public String getGpt4_1106_previewSummaryResponse(@RequestBody String prompt){
        String command = "당신은 보험사의 보험 설계사를 도와주는 비서입니다.\n" +
            "당신의 역할은 아래 규칙에 맞게 \"상담 내용\" 글의 내용을 요약하는 것 입니다.\n" +
            "1. 추천상품을 포함합니다.\n" +
            "2. 위험 설명을 포함합니다.\n";

        return gptClient_gpt4_1106_preview.getGpt4_1106_previewResponse_Text(String.format("%s %s", command, prompt));
    }
}
