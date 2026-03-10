package com.fintech.ai_fintech_platform.finance.chat;
import org.springframework.stereotype.Component;

@Component 
public class ChatPromptBuilder {
    public String buildPrompt(String userInput) {
        return "You are a helpful financial assistant. Answer the following question: " + userInput;
    }
}