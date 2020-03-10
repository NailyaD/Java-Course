package de.telran.repository;

import de.telran.entity.StudentEntity;
import de.telran.dto.StudentsByCourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE StudentEntity s SET s.courseId = :courseId WHERE s.studentId = :studentId")
    int assignStudentToCourse(@Param("studentId") long studentId, @Param("courseId") long courseId);

    @Query("select new StudentsByCourseDto (c.title, s.firstName, s.lastName) " +
           "from Course as c join Student s on s.courseId = c.courseId")
    List<StudentsByCourseDto> getStudentsByCourseId();
}
