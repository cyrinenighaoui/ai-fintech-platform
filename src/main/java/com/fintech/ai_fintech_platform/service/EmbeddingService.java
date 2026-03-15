package com.fintech.ai_fintech_platform.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.ai_fintech_platform.ai.AIClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmbeddingService {

    private final AIClient aiClient;
    private final ObjectMapper mapper = new ObjectMapper();

    public EmbeddingService(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public List<Double> embedText(String text) {

        try {

            String requestBody = """
            {
              "input": "%s",
              "model": "text-embedding-3-large"
            }
            """.formatted(text.replace("\"", "\\\""));

            String response = aiClient.callEmbeddingAPI(requestBody);

            JsonNode root = mapper.readTree(response);

            JsonNode embeddingNode = root
                    .get("data")
                    .get(0)
                    .get("embedding");

            List<Double> embedding = new ArrayList<>();

            for (JsonNode value : embeddingNode) {
                embedding.add(value.asDouble());
            }

            return embedding;

        } catch (Exception e) {

            throw new RuntimeException("Error generating embedding", e);

        }
    }
}