package com.springsecurity.controller;

import com.springsecurity.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Antony",60),
            new Student(2, "Mark", 80)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/students")
    public Student add(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
