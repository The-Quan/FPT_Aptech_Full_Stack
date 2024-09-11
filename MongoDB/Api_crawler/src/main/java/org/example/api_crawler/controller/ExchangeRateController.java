package org.example.api_crawler.controller;

import org.example.api_crawler.entity.ExchangeRate;
import org.example.api_crawler.model.ExchangeRateRepository;
import org.example.api_crawler.model.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @GetMapping("/fetch")
    public String fetchExchangeRates() {
        exchangeRateService.fetchAndSaveExchangeRates();
        return "Exchange rates fetched and saved successfully!";
    }

    @GetMapping("/latest")
    public ExchangeRate getLatestExchangeRates() {
        // Lấy dữ liệu mới nhất từ MongoDB
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findTopByOrderByTimestampDesc();
        return exchangeRate.orElse(null);
    }
}


