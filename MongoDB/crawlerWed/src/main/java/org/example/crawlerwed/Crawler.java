package org.example.crawlerwed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "crawled_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crawler {
    @Id
    private String id;
    private String content;
}
