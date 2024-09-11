package org.example.school_system_analysis_2024;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController// Annotation
@RequestMapping("/api/v1/student/")
public class StudentController {
    //DI
    @Autowired
    private StudentService studentService;

    @GetMapping("/top")
    public List<Student> getTopStudent(){
        return studentService.getALl();
    }

}
