package com.fintech.ai_fintech_platform.finance.chat;
import org.springframework.stereotype.Component;

@Component
public class ChatPromptBuilder {

    public String buildPrompt(String question, String context) {

        return """
        You are a financial analysis assistant.

        Use the following context to answer the question.

        Context:
        %s

        Question:
        %s

        If the context does not contain the answer, say you don't know.
        """.formatted(context, question);

            }
}