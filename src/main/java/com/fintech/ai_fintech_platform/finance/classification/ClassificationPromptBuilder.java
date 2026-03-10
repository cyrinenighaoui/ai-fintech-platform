package com.fintech.ai_fintech_platform.finance.classification;
import org.springframework.stereotype.Component;

@Component
public class ClassificationPromptBuilder {

    public String buildPrompt(String textreceived) {
        return 
        """
        Classify the following financial text into one of these categories:

            - finance
            - crypto
            - macroeconomics
            - regulation
            - technology

            Return ONLY JSON:

            {
            "category": ""
            }
        Text:
        """ 
        + textreceived;
    }

}