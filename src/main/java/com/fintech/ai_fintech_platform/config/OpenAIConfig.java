package com.fintech.ai_fintech_platform.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;
    @Value("${openai.model}")
    private String model;

    public String getApiKey() {
        return apiKey;
    }
    public String getModel() {
        return model;
    }
}