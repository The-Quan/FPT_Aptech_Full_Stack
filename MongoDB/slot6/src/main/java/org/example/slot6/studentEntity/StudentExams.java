package org.example.slot6.studentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExams {
    private int year;
    private String subject;
    private double averageScore;
    private double highestScore;
    private double lowestScore;
}
