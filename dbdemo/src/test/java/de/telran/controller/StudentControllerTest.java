package de.telran.controller;

import de.telran.dto.CourseDto;
import de.telran.dto.SchoolDto;
import de.telran.dto.StudentDto;
import de.telran.entity.StudentEntity;
import de.telran.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService service;

    @Test
    public void testGetAllStudents() throws Exception {
        when(service.getAllStudents()).thenReturn(createListOfStudents());

        mvc.perform(get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())//good for simple debugging
                .andExpect(jsonPath("$[0].studentId").value("0"))
                .andExpect(jsonPath("$[0].firstName").value("Ivan"))
                .andExpect(jsonPath("$[0].lastName").value("Petrov"))
                .andExpect(jsonPath("$[0].courseId").value("1"))
                .andExpect(jsonPath("$[1].studentId").value("1"))
                .andExpect(jsonPath("$[1].firstName").value("Piotr"))
                .andExpect(jsonPath("$[1].lastName").value("Ivanov"))
                .andExpect(jsonPath("$[1].courseId").value("2"));
    }

    @Test
    public void testGetSchoolInfo() throws Exception {
        when(service.getSchoolInfo()).thenReturn(getSchoolData());

        mvc.perform(get("/api/school")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())//good for simple debugging
                .andExpect(jsonPath("$.courses").isArray())
                .andExpect(jsonPath("$.courses[0].title").value("Java"))
                .andExpect(jsonPath("$.courses[0].students[0].firstName").value("Ivan"))
                .andExpect(jsonPath("$.courses[0].students[0].lastName").value("Petrov"))
                .andExpect(jsonPath("$.courses[0].students[1].firstName").value("Piotr"))
                .andExpect(jsonPath("$.courses[0].students[1].lastName").value("Ivanov"))
                .andExpect(jsonPath("$.courses[1].title").value("QA"))
                .andExpect(jsonPath("$.courses[1].students[0].firstName").value("Alexei"))
                .andExpect(jsonPath("$.courses[1].students[0].lastName").value("Alexandrov"))
                .andExpect(jsonPath("$.courses[1].students[1].firstName").value("Alexander"))
                .andExpect(jsonPath("$.courses[1].students[1].lastName").value("Alekseyev"));
    }

    @Test
    public void testCreateStudent() throws Exception {

        StudentEntity s1 = new StudentEntity();

        when(service.createStudent(s1))
                .thenReturn(createNewStudent());

        mvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(s1)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.studentId").value("0"))
                .andExpect(jsonPath("$.firstName").value("Ivan"))
                .andExpect(jsonPath("$.lastName").value("Petrov"))
                .andExpect(jsonPath("$.courseId").value("1"));
    }

    private StudentEntity createNewStudent() {
        StudentEntity student1 = new StudentEntity();
        student1.setStudentId(0L);
        student1.setFirstName("Ivan");
        student1.setLastName("Petrov");
        student1.setCourseId(1L);
        return student1;
    }

    private SchoolDto getSchoolData() {
        StudentDto s1 = new StudentDto("Ivan", "Petrov");
        StudentDto s2 = new StudentDto("Piotr", "Ivanov");
        CourseDto c1 = new CourseDto("Java", Arrays.asList(s1, s2));

        StudentDto s3 = new StudentDto("Alexei", "Alexandrov");
        StudentDto s4 = new StudentDto("Alexander", "Alekseyev");
        CourseDto c2 = new CourseDto("QA", Arrays.asList(s3, s4));

        return new SchoolDto(Arrays.asList(c1, c2));
    }

    private List<StudentEntity> createListOfStudents() {
        StudentEntity student1 = new StudentEntity();
        student1.setStudentId(0L);
        student1.setFirstName("Ivan");
        student1.setLastName("Petrov");
        student1.setCourseId(1L);
        StudentEntity student2 = new StudentEntity();
        student2.setStudentId(1L);
        student2.setFirstName("Piotr");
        student2.setLastName("Ivanov");
        student2.setCourseId(2L);

        return Arrays.asList(student1, student2);
    }

}
