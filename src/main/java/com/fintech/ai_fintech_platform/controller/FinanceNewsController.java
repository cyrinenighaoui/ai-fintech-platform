package com.fintech.ai_fintech_platform.controller;

import com.fintech.ai_fintech_platform.dto.AnalysisResponse;
import com.fintech.ai_fintech_platform.dto.NewsRequest;
import com.fintech.ai_fintech_platform.service.NewsAnalysisService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class FinanceNewsController {

    private final NewsAnalysisService newsAnalysisService;

    public FinanceNewsController(NewsAnalysisService newsAnalysisService) {
        this.newsAnalysisService = newsAnalysisService;
    }

    @PostMapping("/analyze")
    public AnalysisResponse analyzeNews(@RequestBody NewsRequest request) { //request body sert a recevoir le texte de la news à analyser et convertir le json en objet java newrequest
        return newsAnalysisService.analyzeNews(request.getNewsText());
    }
}