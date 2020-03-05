package de.telran.controller;

import de.telran.model.Student;
import de.telran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping ("/api/students")
    List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping ("/api/students")
    Student createStudent (@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping ("/api/students")
    Student assignStudentToCourse (@RequestBody Student student) {
        service.assignStudentToCourse(student);
        return service.getStudentById(student.getStudentId());
    }
}
