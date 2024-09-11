package org.example.crawlerwed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawledService {

    @Autowired
    private CrawlerRepository crawlerRepository;

    public List<String> crawl(String url) throws IOException {
        List<String> data = new ArrayList<>();

        // Gửi yêu cầu HTTP và lấy nội dung trang
        Document document = Jsoup.connect(url).get();

        // Lấy tất cả các thẻ <div> từ trang
        Elements divs = document.select("div");

        // Lặp qua các thẻ <div> và lấy nội dung
        for (Element div : divs) {
            String content = div.text(); // Lấy nội dung văn bản của thẻ <div>
            data.add(content);

            // Lưu vào MongoDB
            Crawled crawled = new Crawled(content);
            crawledRepository.save(crawled);
        }

        return data;
    }
}
