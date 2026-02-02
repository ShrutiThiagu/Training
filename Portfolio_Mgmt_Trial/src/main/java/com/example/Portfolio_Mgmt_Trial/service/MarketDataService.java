package com.example.Portfolio_Mgmt_Trial.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Portfolio_Mgmt_Trial.model.MarketMetrics;
import org.springframework.stereotype.Service;

@Service
public class MarketDataService {
    public MarketMetrics parse(String json) throws Exception {
        JsonNode node = new ObjectMapper().readTree(json).get("Time Series (Daily)");
        String latestDate = node.fieldNames().next();
        JsonNode data = node.get(latestDate);
        double volume = data.get("5. volume").asDouble();
        return new MarketMetrics(data.get("4. close").asDouble(), volume, volume > 1000000);
    }

    public double calculateScore(int hype, MarketMetrics metrics) {
        double score = (hype * 0.5) + (metrics.isVolumeSurge() ? 50 : 0);
        return Math.min(100, score);
    }
}