package org.example.slot6.studentRepository;

import org.bson.Document;
import org.example.slot6.studentEntity.StudentExams;
import org.example.slot6.studentEntity.StudentPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Tính điểm trung bình, điểm cao nhất, điểm thấp nhất và tỷ lệ đỗ theo năm
    public List<StudentPerformance> findStudentPerformance() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("exams"),
                Aggregation.addFields()
                        .addFieldWithValue("year", new Document("$year", new Document("$toDate", "$exams.date")))
                        .build(),
                Aggregation.group("year", "name")
                        .avg("exams.score").as("averageScore") // Tính điểm trung bình
                        .min("exams.score").as("minScore") // Tính điểm thấp nhất
                        .max("exams.score").as("maxScore") // Tính điểm cao nhất
                        .count().as("totalExams") // Tổng số bài thi
                        .sum(ConditionalOperators.Cond
                                .when(Criteria.where("exams.score").gte(70))
                                .then(1)
                                .otherwise(0))
                        .as("passedExams"),
                Aggregation.project("year", "name", "averageScore", "minScore", "maxScore", "totalExams", "passedExams")
                        .and(ConditionalOperators.Cond
                                .when(Criteria.where("totalExams").gt(0))
                                .then(
                                        new Document("$multiply", Arrays.asList(
                                                new Document("$divide", Arrays.asList("$passedExams", "$totalExams")),
                                                100.0
                                        ))
                                )
                                .otherwise(0.0))
                        .as("passRate"),
                Aggregation.sort(org.springframework.data.domain.Sort.Direction.DESC, "year", "averageScore") // Sắp xếp theo năm và điểm trung bình giảm dần
        );

        AggregationResults<StudentPerformance> results = mongoTemplate.aggregate(aggregation, "Student", StudentPerformance.class);
        return results.getMappedResults();
    }
    public List<StudentExams> getALlByYear(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("$exams"),
                Aggregation.addFields().addFieldWithValue("year", new Document("$year", new Document("$toDate", "$exams.date")))
                        .build(),
                Aggregation.match(Criteria.where("year").gte(2021).lte(2024)),
                Aggregation.group("year", "exams.subject")
                        .avg("exams.score").as("averageScore")
                        .max("exams.score").as("highestScore")
                        .min("exams.score").as("lowestScore"),
                Aggregation.sort(Sort.by(Sort.Direction.ASC, "_id.year", "_id.subject")),
                Aggregation.project()
                        .andExpression("_id.year").as("year")
                        .andExpression("_id.subject").as("subject")
                        .andInclude("averageScore", "highestScore", "lowestScore")
                        .andExclude("_id")
                );
        AggregationResults<StudentExams> results = mongoTemplate.aggregate(aggregation, "Student",StudentExams.class);
        return results.getMappedResults();
    }
}
