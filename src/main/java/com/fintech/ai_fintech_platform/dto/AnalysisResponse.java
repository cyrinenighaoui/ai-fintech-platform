package com.fintech.ai_fintech_platform.dto;

public class AnalysisResponse {

    private String company;
    private String sector;
    private String impact;

    public AnalysisResponse(String company, String sector, String impact) {
        this.company = company;
        this.sector = sector;
        this.impact = impact;
    }

    public String getCompany() {
        return company;
    }

    public String getSector() {
        return sector;
    }

    public String getImpact() {
        return impact;
    }
}