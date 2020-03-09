package de.telran.repository;

import de.telran.entity.StudentEntity;
import de.telran.entity.StudentsByCourseEntity;
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

    //@Query("select c.title, s.first_name, s.last_name from Course as c join StudentEntity as s on s.course_id = c.course_id order by c.title")
    List<StudentsByCourseEntity> getStudentsByCourseId(@Param("courseId") long courseId);
}
