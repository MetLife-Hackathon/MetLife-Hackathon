package net.azurewebsites.appmetlifeteam10.chatbot;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.azurewebsites.appmetlifeteam10.chatbot.dto.RequestChatbot;
import net.azurewebsites.appmetlifeteam10.chatbot.dto.RequestChatbotAPI;
import net.azurewebsites.appmetlifeteam10.chatbot.dto.ResponseChatbot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    private final RestTemplate restTemplate;

    @PostMapping("")
    public ResponseChatbot serveAIResponse(@RequestBody @Valid RequestChatbot requestChatbot) {
        String url = "http://:8080/api/v1/search/similarity/vectors";
        String input;

        if (requestChatbot.getHistory() != null) {
            input = "### 당신과 고객과의 이전 대화 내용은 다음과 같습니다.\n" + requestChatbot.getHistory()
                    + "### 현재 질문은 다음과 같습니다.\n" + requestChatbot.getQuestion();
        } else {
            input = requestChatbot.getQuestion();
        }

        RequestChatbotAPI requestChatbotAPI = RequestChatbotAPI.builder()
                .input(input)
                .model("text-embedding-3-small")
                .build();

        String response = restTemplate.postForObject(url, requestChatbotAPI, String.class);
        ResponseChatbot responseChatbot = ResponseChatbot.builder().answer(response).build();
        return responseChatbot;
    }
}
