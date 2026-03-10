package com.fintech.ai_fintech_platform.controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fintech.ai_fintech_platform.dto.ClassificationRequest;
import com.fintech.ai_fintech_platform.dto.ClassificationResponse;
import com.fintech.ai_fintech_platform.service.ClassificationService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/classification")
public class ClassificationController{    
    private final ClassificationService classificationService;
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }
    @PostMapping("/classify")
    public ClassificationResponse classifyText(@RequestBody ClassificationRequest request) {

    return classificationService.classifyText(request);
    //request.get dans service 
    }
}