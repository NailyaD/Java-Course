package de.telran.service;

import de.telran.dto.CourseDto;
import de.telran.dto.SchoolDto;
import de.telran.dto.StudentDto;
import de.telran.entity.StudentEntity;
import de.telran.dto.StudentsByCourseDto;
import de.telran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public StudentEntity createStudent(StudentEntity student) {
        return repository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    public StudentEntity getStudentById (Long studentId) {
        return repository.getOne(studentId);
    }

    public int assignStudentToCourse(StudentEntity student) {
        return repository.assignStudentToCourse(student.getStudentId(), student.getCourseId());
    }

    public SchoolDto getSchoolInfo() {
        List<StudentsByCourseDto> studentsByCourse = repository.getStudentsByCourseId();

        System.out.println(studentsByCourse);

        List<CourseDto> courses = new ArrayList<>();

        Map<String, List<StudentsByCourseDto>> collect = studentsByCourse
                .stream()
                .collect(Collectors.groupingBy(StudentsByCourseDto::getTitle));

        collect.forEach((k, v) ->
                courses.add(new CourseDto(k, v.stream().map(s -> new StudentDto(s.getFirstName(), s.getLastName()))
                        .collect(toList()))));

        return new SchoolDto(courses);
    }
}
