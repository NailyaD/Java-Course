package de.telran.service;

import de.telran.dto.SchoolDto;
import de.telran.dto.StudentsByCourseDto;
import de.telran.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public StudentService employeeService() {
            return new StudentService();
        }
    }

    @Autowired
    StudentService service;

    @MockBean
    StudentRepository repo;

    @Test
    public void testGetSchoolInfo() {
        when(repo.getStudentsByCourseId()).thenReturn(createStudentsByCourse());

        SchoolDto schoolInfo = service.getSchoolInfo();

        assertNotNull(schoolInfo);
    }

    private List<StudentsByCourseDto> createStudentsByCourse() {
        StudentsByCourseDto s1 = new StudentsByCourseDto("Java", "Ivan", "Petrov");
        StudentsByCourseDto s2 = new StudentsByCourseDto("QA", "Piotr", "Ivanov");

        return Arrays.asList(s1, s2);
    }
}
