package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class StudentModel {
    private int rollNo;
    private String name;
    private String email;
    private int mobile;
    private String studyYear;
}
