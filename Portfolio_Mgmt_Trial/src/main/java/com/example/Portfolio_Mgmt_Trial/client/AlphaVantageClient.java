package com.example.Portfolio_Mgmt_Trial.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AlphaVantageClient {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${alphavantage.api.key}") private String apiKey;

    public String getNewsSentiment(String symbol) {
        return restTemplate.getForObject("https://www.alphavantage.co/query?function=NEWS_SENTIMENT&tickers=" + symbol + "&apikey=" + apiKey, String.class);
    }

    public String getDailyPrices(String symbol) {
        return restTemplate.getForObject("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey, String.class);
    }
}
