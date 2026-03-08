package com.fintech.ai_fintech_platform.finance.news;

import com.fintech.ai_fintech_platform.dto.AnalysisResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
@Component
public class NewsAnalyzer {

    private final PromptBuilder promptBuilder;
    private final AIClient aiClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public NewsAnalyzer(PromptBuilder promptBuilder, AIClient aiClient) {
        this.promptBuilder = promptBuilder;
        this.aiClient = aiClient;
    }

    public AnalysisResponse analyze(String newsText) {

        try {

            String prompt = promptBuilder.buildNewsAnalysisPrompt(newsText);

            String aiResponse = aiClient.callOpenAI(prompt);

            JsonNode root = objectMapper.readTree(aiResponse);

            String content = root
                    .get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

            JsonNode result = objectMapper.readTree(content);

            String company = result.get("company").asText();
            String sector = result.get("sector").asText();
            String impact = result.get("impact").asText();

            return new AnalysisResponse(company, sector, impact);

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while analyzing news", e);
        }
    }
}