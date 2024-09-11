package org.example.api_crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateResponse {
    private boolean success;
    private long timestamp;
    private String source;
    private Map<String, Double> quotes;
}
