package com.fintech.ai_fintech_platform.service;

import com.fintech.ai_fintech_platform.dto.AnalysisResponse;
import com.fintech.ai_fintech_platform.finance.news.NewsAnalyzer;
import org.springframework.stereotype.Service;

@Service
public class NewsAnalysisService {

    private final NewsAnalyzer newsAnalyzer;

    public NewsAnalysisService(NewsAnalyzer newsAnalyzer) {
        this.newsAnalyzer = newsAnalyzer;
    }

    public AnalysisResponse analyzeNews(String newsText) {
        return newsAnalyzer.analyze(newsText);
    }
}