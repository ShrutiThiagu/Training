package com.example.Portfolio_Mgmt_Trial.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SentimentService {
    private final ChatClient chatClient;

    public SentimentService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public int analyzeHype(String news) {
        String response = chatClient.prompt()
                .user("Analyze these stock headlines: " + news + ". On a scale of 0-100, how much retail FOMO/hype is present? Return only the number.")
                .call().content();
        return Integer.parseInt(response.replaceAll("[^0-9]", ""));
    }
}