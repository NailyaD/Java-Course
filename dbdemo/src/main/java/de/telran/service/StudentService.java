package de.telran.service;

import de.telran.dto.SchoolDto;
import de.telran.entity.StudentEntity;
import de.telran.entity.StudentsByCourseEntity;
import de.telran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    public StudentEntity createStudent(StudentEntity student) {
        return repository.save(student);
    }

    public void assignStudentToCourse(StudentEntity student) {
        repository.assignStudentToCourse(student.getStudentId(), student.getCourseId());
    }

    public StudentEntity getStudentById (Long studentId) {
        return repository.getOne(studentId);
    }

    public SchoolDto getSchoolInfo() {
        List<StudentsByCourseEntity> studentsByCourse = repository.getStudentsByCourseId(1);

        SchoolDto school = new SchoolDto(Collections.EMPTY_LIST);
        //map studentsByCourse to School
        return school;
    }
}
