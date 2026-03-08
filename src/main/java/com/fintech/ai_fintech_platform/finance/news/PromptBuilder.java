package com.fintech.ai_fintech_platform.finance.news;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    public String buildNewsAnalysisPrompt(String newsText) {
        return """
                You are a financial news analysis assistant.

                Analyze the financial news and extract:
                - company
                - sector
                - market impact (Bullish, Bearish, Neutral)

                Return ONLY valid JSON in this format:

                {
                "company": "string",
                "sector": "string",
                "impact": "string"
                }

                News:
                """ + newsText;
    }
}