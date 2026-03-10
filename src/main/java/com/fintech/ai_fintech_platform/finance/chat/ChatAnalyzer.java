package com.fintech.ai_fintech_platform.finance.chat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import com.fintech.ai_fintech_platform.ai.AIClient;
import com.fintech.ai_fintech_platform.dto.ChatResponse;

@Component
public class ChatAnalyzer {
    private final ChatPromptBuilder chatPromptBuilder;
    private final AIClient aiClient;

    public ChatAnalyzer(ChatPromptBuilder chatPromptBuilder, AIClient aiClient) {
        this.chatPromptBuilder = chatPromptBuilder;
        this.aiClient = aiClient;
    }

     public ChatResponse ask(String question) {
        String prompt = chatPromptBuilder.buildPrompt(question);
        String aiResponse = aiClient.callOpenAI(prompt);
        //serialize AI response to extract answer
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(aiResponse);
            String answer = root.get("choices").get(0).get("message").get("content").asText();
            return new ChatResponse(answer);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing AI response", e);
        }
     }
}