package com.fintech.ai_fintech_platform.dto;

public class ClassificationResponse{
    private String classification;

    public ClassificationResponse(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
   
}