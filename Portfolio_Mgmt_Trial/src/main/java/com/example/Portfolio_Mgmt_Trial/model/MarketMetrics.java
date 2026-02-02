package com.example.Portfolio_Mgmt_Trial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class MarketMetrics {
    private double closePrice;
    private double volume;
    private boolean isVolumeSurge;
}