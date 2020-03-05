package de.telran.webmodel;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Builder

public class StudentForm {

    private int studentId;
    private String firstName;
    private String lastName;
    private int courseId;
}
