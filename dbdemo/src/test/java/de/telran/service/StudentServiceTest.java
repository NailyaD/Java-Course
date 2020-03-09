package de.telran.service;

import de.telran.dto.SchoolDto;
import de.telran.entity.StudentsByCourseEntity;
import de.telran.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @MockBean
    StudentRepository repo;

    StudentService service = new StudentService();

    @Test
    public void testGetSchoolInfo() {
        when(repo.getStudentsByCourseId(0L)).thenReturn(createStudentsByCourse());

        SchoolDto schoolInfo = service.getSchoolInfo();

        assertNotNull(schoolInfo);
    }

    private List<StudentsByCourseEntity> createStudentsByCourse() {
        StudentsByCourseEntity s1 = new StudentsByCourseEntity(0L, "Java", "Ivan", "Petrov");
        StudentsByCourseEntity s2 = new StudentsByCourseEntity(1L, "QA", "Piotr", "Ivanov");

        return Arrays.asList(s1, s2);
    }
}
