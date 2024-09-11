package org.example.slot6.studentController;

import org.example.slot6.studentEntity.StudentExams;
import org.example.slot6.studentEntity.StudentPerformance;
import org.example.slot6.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/performance")
    public List<StudentPerformance> getStudentPerformance() {
        return studentService.getStudentPerformance();
    }
    @GetMapping("/studentexambyyear")
    public List<StudentExams> getStudentExamsByYear() {
        return studentService.getStudentExamsByYear();
    }
}
