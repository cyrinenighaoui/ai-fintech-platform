package com.fintech.ai_fintech_platform.dto;



public class ChatResponse {
    private String answer;
    public ChatResponse(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
}