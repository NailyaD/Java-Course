package de.telran.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class StudentsByCourseEntity {
    @Id
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
}
