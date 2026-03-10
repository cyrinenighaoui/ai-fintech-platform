package com.fintech.ai_fintech_platform.service;

import com.fintech.ai_fintech_platform.dto.ClassificationRequest;
import com.fintech.ai_fintech_platform.dto.ClassificationResponse;
import com.fintech.ai_fintech_platform.finance.classification.ClassificationAnalyzer;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {

    private final ClassificationAnalyzer classificationAnalyzer;

    public ClassificationService(ClassificationAnalyzer classificationAnalyzer) {
        this.classificationAnalyzer = classificationAnalyzer;
    }

    public ClassificationResponse classifyText(ClassificationRequest request) {

        return classificationAnalyzer.classify(request.getTextReceived());
    }
}