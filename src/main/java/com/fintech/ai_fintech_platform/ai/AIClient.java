package com.fintech.ai_fintech_platform.ai;
import com.fintech.ai_fintech_platform.config.OpenAIConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Component
public class AIClient {

    private final OpenAIConfig openAIConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    public AIClient(OpenAIConfig openAIConfig) {
        this.openAIConfig = openAIConfig;
    }

    public String callOpenAI(String prompt) {

        String url = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openAIConfig.getApiKey());
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "model", openAIConfig.getModel(),
                "messages", new Object[]{
                        Map.of("role", "user", "content", prompt)
                }
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }
}