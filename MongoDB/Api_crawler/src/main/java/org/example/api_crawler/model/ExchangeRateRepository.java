package org.example.api_crawler.model;

import org.example.api_crawler.entity.ExchangeRate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends MongoRepository<ExchangeRate, String> {
    Optional<ExchangeRate> findTopByOrderByTimestampDesc();
}
