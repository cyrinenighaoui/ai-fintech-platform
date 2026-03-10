package com.fintech.ai_fintech_platform.finance.classification;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import com.fintech.ai_fintech_platform.ai.AIClient;
import com.fintech.ai_fintech_platform.dto.ClassificationResponse;


@Component
public class ClassificationAnalyzer {
    //inject prompt builder and AI client
    private final ClassificationPromptBuilder promptBuilder;
    private final AIClient aiClient;
    public ClassificationAnalyzer(ClassificationPromptBuilder promptBuilder, AIClient aiClient) {
        this.promptBuilder = promptBuilder;
        this.aiClient = aiClient;
    }
    public ClassificationResponse classify(String textreceived) {
        String prompt = promptBuilder.buildPrompt(textreceived);
        String aiResponse = aiClient.callOpenAI(prompt);
        //parse AI response to extract classification
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(aiResponse);
            String classification = root.get("choices").get(0).get("message").get("content").asText();

            JsonNode result = mapper.readTree(classification);
            String category = result.get("category").asText();
            return new ClassificationResponse(category);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing AI response", e);
        }

        
    }
}