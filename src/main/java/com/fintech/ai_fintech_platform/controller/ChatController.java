package com.fintech.ai_fintech_platform.controller;
import com.fintech.ai_fintech_platform.dto.ChatRequest;
import com.fintech.ai_fintech_platform.dto.ChatResponse;
import com.fintech.ai_fintech_platform.service.ChatService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @PostMapping("/ask")
    public ChatResponse askQuestion(@RequestBody ChatRequest request) {
        return chatService.ask(request);
    }


}