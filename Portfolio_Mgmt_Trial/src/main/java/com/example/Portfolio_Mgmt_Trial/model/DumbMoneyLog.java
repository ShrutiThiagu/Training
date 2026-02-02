package com.example.Portfolio_Mgmt_Trial.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class DumbMoneyLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private double score;
    private int aiHype;
    private LocalDateTime timestamp = LocalDateTime.now();

    public void setSymbol(String symbol) {
    }

    public void setScore(double score) {
    }

    public void setAiHype(int hype) {
    }
}
