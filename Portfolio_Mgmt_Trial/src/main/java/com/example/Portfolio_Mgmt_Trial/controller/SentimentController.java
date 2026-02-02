package com.example.Portfolio_Mgmt_Trial.controller;

import com.example.Portfolio_Mgmt_Trial.client.AlphaVantageClient;
import com.example.Portfolio_Mgmt_Trial.model.*;
import com.example.Portfolio_Mgmt_Trial.repository.SentimentHistoryRepository;
import com.example.Portfolio_Mgmt_Trial.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.Map;

@RestController @RequestMapping("/api/sentiment")
public class SentimentController {
    @Autowired private AlphaVantageClient client;
    @Autowired private SentimentService ai;
    @Autowired private MarketDataService market;
    @Autowired private SentimentHistoryRepository repo;

    @GetMapping("/{symbol}")
    public Map<String, Object> get(@PathVariable String symbol) throws Exception {
        int hype = ai.analyzeHype(client.getNewsSentiment(symbol));
        MarketMetrics metrics = market.parse(client.getDailyPrices(symbol));
        double score = market.calculateScore(hype, metrics);

        DumbMoneyLog log = new DumbMoneyLog();
        log.setSymbol(symbol);
        log.setScore(score);
        log.setAiHype(hype);
        repo.save(log);

        return Map.of("symbol", symbol, "score", score, "hype", hype);
    }
}
