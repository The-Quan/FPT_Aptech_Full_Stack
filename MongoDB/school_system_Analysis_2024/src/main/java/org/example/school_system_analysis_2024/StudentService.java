package org.example.school_system_analysis_2024;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    // dependency injection(DI) => cần học kĩ
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getALl(){
        return studentRepository.findAll().stream()
                .filter(Student::isTopStudent)
                .collect(Collectors.toList());

    }
}
