package de.telran.controller;

import de.telran.dto.SchoolDto;
import de.telran.entity.StudentEntity;
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
    List<StudentEntity> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping ("/api/students")
    StudentEntity createStudent (@RequestBody StudentEntity student) {
        return service.createStudent(student);
    }

    @PutMapping ("/api/students")
    StudentEntity assignStudentToCourse (@RequestBody StudentEntity student) {
        service.assignStudentToCourse(student);
        return service.getStudentById(student.getStudentId());
    }

    @GetMapping ("/api/school")
    SchoolDto getSchoolInfo() {
        return service.getSchoolInfo();
    }
}
