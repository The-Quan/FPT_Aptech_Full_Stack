package org.example.slot6.studentService;

import org.example.slot6.studentEntity.StudentExams;
import org.example.slot6.studentEntity.StudentPerformance;
import org.example.slot6.studentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentPerformance> getStudentPerformance(){
        return studentRepository.findStudentPerformance();
    }
    public List<StudentExams> getStudentExamsByYear(){
        return studentRepository.getALlByYear();
    }
}
