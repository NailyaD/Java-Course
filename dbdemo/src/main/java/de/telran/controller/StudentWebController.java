package de.telran.controller;

import de.telran.service.StudentService;
import de.telran.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import de.telran.webmodel.StudentForm;

@Controller
public class StudentWebController {

    @Autowired
    StudentService service;

    @GetMapping("/students")
    public String getIndexForm(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        model.addAttribute("students", service.getStudents());
        return "index";
    }

    @PostMapping("addStudent")
    public String addStudent(Model model, StudentForm form) {
        Student student = new Student(form.getStudentId, form.getFirstName(), form.getLastName(), form.getCourseId);
        service.addStudent(student);

        model.addAttribute("students", service.getStudents());

        return "index";
    }
}
