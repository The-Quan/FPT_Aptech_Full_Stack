package org.example.api_crawler.model;

import org.example.api_crawler.entity.ExchangeRate;
import org.example.api_crawler.entity.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class ExchangeRateService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public void fetchAndSaveExchangeRates() {
        String apiKey = "fdddecaa7d469c8a36c6e089263880d3"; // Thay bằng API key của bạn
        String url = String.format("https://api.currencylayer.com/live?access_key=%s", apiKey);

        try {
            // Gọi API để lấy dữ liệu
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);

            if (response != null && response.isSuccess()) {
                // Chuyển đổi dữ liệu và lưu vào MongoDB
                ExchangeRate exchangeRate = new ExchangeRate();
                exchangeRate.setSuccess(response.isSuccess());
                exchangeRate.setTimestamp(response.getTimestamp());
                exchangeRate.setSource(response.getSource());
                exchangeRate.setQuotes(response.getQuotes());

                exchangeRateRepository.save(exchangeRate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

