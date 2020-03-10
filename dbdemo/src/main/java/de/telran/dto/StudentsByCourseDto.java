package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentsByCourseDto {
    private String title;
    private String firstName;
    private String lastName;
}
