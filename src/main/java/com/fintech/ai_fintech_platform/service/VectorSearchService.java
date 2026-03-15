package com.fintech.ai_fintech_platform.service;

import com.fintech.ai_fintech_platform.model.DocumentChunk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VectorSearchService {

    // Simulated documents for now
    private final List<DocumentChunk> documents = List.of(
            new DocumentChunk(
                    "Tesla stock dropped after weaker than expected earnings.",
                    "Reuters"
            ),
            new DocumentChunk(
                    "The Federal Reserve raised interest rates, impacting stock markets.",
                    "Bloomberg"
            ),
            new DocumentChunk(
                    "AI companies are seeing strong growth due to increased investment.",
                    "Financial Times"
            )
    );

    public List<DocumentChunk> search(String question) {

        // For now return all docs (temporary)
        // Later this will be vector search

        return new ArrayList<>(documents);
    }
}