package com.hackaton.javaelasticsearch.domain.gpt.search.controller;

import com.hackaton.javaelasticsearch.domain.gpt.search.model.CreateEmbeddingRequest;
import com.hackaton.javaelasticsearch.domain.gpt.search.model.EmbeddingInfoDTO;
import com.hackaton.javaelasticsearch.domain.gpt.search.service.GptSearchService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/Text")
public class GptSearchController {

    private final GptSearchService gptClient_gpt4_1106_preview;

    @PostMapping("/gpt_v4_1106_preview_Text")
    public String getGpt4_1106_previewResponse_Text(@RequestBody String prompt) {
        return gptClient_gpt4_1106_preview.getGpt4_1106_previewResponse_Text(prompt);
    }
    /*
    @PostMapping("/gpt_v4_1106_preview/getCompAns")
    public String getGpt4_1106_previewTranslationArticleKR_EN(@RequestBody String prompt) {

    }
    */
}

