package net.azurewebsites.appmetlifeteam10.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class RequestChatbotAPI {
    private String input;
    private String model;
}
