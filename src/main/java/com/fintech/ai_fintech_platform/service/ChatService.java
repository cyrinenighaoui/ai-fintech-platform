package com.fintech.ai_fintech_platform.service;
import com.fintech.ai_fintech_platform.ai.AIClient;
import com.fintech.ai_fintech_platform.dto.ChatRequest;
import com.fintech.ai_fintech_platform.dto.ChatResponse;
import org.springframework.stereotype.Service;
import com.fintech.ai_fintech_platform.finance.chat.ChatAnalyzer;



@Service
public class ChatService {
    private final ChatAnalyzer chatAnalyzer;
    public ChatService(ChatAnalyzer chatAnalyzer) {
        this.chatAnalyzer = chatAnalyzer;
    }
    public ChatResponse ask(ChatRequest request) {

        return chatAnalyzer.ask(request.getUserMessage());
    }

}