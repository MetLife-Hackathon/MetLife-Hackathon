package net.azurewebsites.appmetlifeteam10.chatbot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestChatbot {
    private String history;
    @NotNull
    private String question;
}
