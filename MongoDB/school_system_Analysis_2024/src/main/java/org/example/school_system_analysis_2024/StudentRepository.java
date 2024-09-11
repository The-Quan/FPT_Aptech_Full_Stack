package org.example.school_system_analysis_2024;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findAll();
}
