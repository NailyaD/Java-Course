package de.telran.service;

import de.telran.model.Student;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new LinkedList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int studentId) {
        return students.get(studentId);
    }

}
