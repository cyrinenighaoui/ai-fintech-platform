package com.fintech.ai_fintech_platform.model;


public class DocumentChunk {
    private String content;
    private String source;

    public DocumentChunk(String content, String source) {
        this.content = content;
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public String getSource() {
        return source;
    }
}