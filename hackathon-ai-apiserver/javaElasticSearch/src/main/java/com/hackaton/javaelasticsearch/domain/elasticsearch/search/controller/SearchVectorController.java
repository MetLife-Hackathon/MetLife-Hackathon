package com.hackaton.javaelasticsearch.domain.elasticsearch.search.controller;

import com.hackaton.javaelasticsearch.domain.elasticsearch.search.model.SearchVectorRequest;
import com.hackaton.javaelasticsearch.domain.elasticsearch.search.model.SearchVectorResponse;
import com.hackaton.javaelasticsearch.domain.elasticsearch.search.service.SearchVectorService;
import java.util.ArrayList;
import java.util.List;

import com.hackaton.javaelasticsearch.domain.gpt.search.model.CreateEmbeddingRequest;
import com.hackaton.javaelasticsearch.domain.gpt.search.model.CreateEmbeddingResponse;
import com.hackaton.javaelasticsearch.domain.gpt.search.service.GptSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SearchVectorController {

    private final SearchVectorService searchVectorService;
    private final GptSearchService gptSearchService;
    private final GptSearchService gptClient_gpt4_1106_preview;


    @PostMapping("/only-search/similarity/vectors")
    public ResponseEntity<List<SearchVectorResponse.SearchResult>> onlySearchFromES(@RequestBody SearchVectorRequest request) {

        float[] vector = request.getVector(); // 요청에서 벡터 데이터를 추출
        float minSimilarity = 0.7f; // 최소 유사도 임계값 설정

        // 서비스 메서드를 호출하여 유사도 검색 수행
        var searchHits = searchVectorService.findBySimilarity(vector, minSimilarity);

        // 검색 결과를 SearchVectorResponse로 변환
        List<SearchVectorResponse.SearchResult> results = new ArrayList<>();
        for (var hit : searchHits.getSearchHits()) {
            results.add(new SearchVectorResponse.SearchResult(hit.getContent().getId(), hit.getContent().getText(), hit.getScore()));
        }

        return ResponseEntity.ok(results);
    }

    @PostMapping("/search/similarity/vectors")
    //public ResponseEntity<List<SearchVectorResponse.SearchResult>> searchBySimilarity(@RequestBody SearchVectorRequest request) {
    public String searchBySimilarity(@RequestBody SearchVectorRequest request) {
        CreateEmbeddingRequest c = new CreateEmbeddingRequest(request.getInput(), request.getModel());

        Float[] vectors = gptSearchService.createEmbeddings(c);
        float[] vector = new float[vectors.length];

        for (int i = 0; i < vectors.length; i++) {
            vector[i] = vectors[i] != null ? vectors[i] : 0.0f;
        }
        // 원본값 + 프롬프트를 통해서 오픈 api 콜

        //float[] vector = request.getVector(); // 요청에서 벡터 데이터를 추출
        request.setVector(vector);
        float minSimilarity = 0.7f; // 최소 유사도 임계값 설정

        // 서비스 메서드를 호출하여 유사도 검색 수행
        var searchHits = searchVectorService.findBySimilarity(vector, minSimilarity);

        // 검색 결과를 SearchVectorResponse로 변환
        List<SearchVectorResponse.SearchResult> results = new ArrayList<>();
        for (var hit : searchHits.getSearchHits()) {
            results.add(new SearchVectorResponse.SearchResult(hit.getContent().getId(), hit.getContent().getText(), hit.getScore()));
        }

        String command = "당신은 보험사의 보험 설계사를 도와주는 비서입니다.\n" +
                "당신의 역할은 다음과 같습니다.\n" +
                "1.고객의 상황을 파악하고 제공된 데이터를 토대로 고객에게 맞춤형 보험을 추천하는 역할을 합니다.\n"+
                "2.고객의 상황을 파악하고 제공된 데이터를 토대로 고객에게 맞춤형 보험을 설계해줍니다\n"+
                "3.고객의 성향을 파악하고 제공된 데이터를 토대로 고객에게 맞춤형 보험 상품들과 가격을 추천해줍니다.\n"+
                "4.고객의 성향을 파악하고 제공된 데이터를 토대로 고객이 보험을 들지 않으면 발생하는 위험에 대해 설명해줍니다.\n"+
                "주의 사항이 있습니다.\n"+
                //"당신은 보험과 관련 없는 질문이나 요청에는 답변을 제공하지 않습니다.\n"+
                "당신은 다음과 같은 데이터를 참고할 수 있습니다.\n"+
                "데이터 :\n"
                ;
        String insurance = results.get(0).getText() + results.get(1).getText();

        String lastcommand = "데이터를 보고 보험을 하나 추천해주시고, 보험에 관한 설명을 해주세요.";
        String s = gptClient_gpt4_1106_preview.getGpt4_1106_previewResponse_Text(String.format("%s %s", command,  insurance + lastcommand));

        return s;
    }
}
