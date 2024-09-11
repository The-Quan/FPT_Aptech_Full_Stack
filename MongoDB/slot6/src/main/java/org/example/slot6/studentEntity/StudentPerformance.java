package org.example.slot6.studentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentPerformance {
    private Integer year;
    private String name;
    private Double averageScore;
    private Double minScore;
    private Double maxScore;
    private Integer totalExams;
    private Integer passedExams;
    private Double passRate;
}
