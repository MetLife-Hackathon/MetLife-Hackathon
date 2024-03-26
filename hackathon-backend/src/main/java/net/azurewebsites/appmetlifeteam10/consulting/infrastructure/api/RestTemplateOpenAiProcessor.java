package net.azurewebsites.appmetlifeteam10.consulting.infrastructure.api;

import lombok.RequiredArgsConstructor;
import net.azurewebsites.appmetlifeteam10.consulting.infrastructure.api.dto.OpenAiProcessorRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestTemplateOpenAiProcessor {

    private static final String OPENAI_API_DOMAIN = "http://:8080/api/summarize";

    private final RestTemplate restTemplate;

    public String summarize(final String prompt) {
        final OpenAiProcessorRequest request = new OpenAiProcessorRequest(prompt);
        final String summary = restTemplate.postForObject(OPENAI_API_DOMAIN, request, String.class);
        return summary;
    }
}
