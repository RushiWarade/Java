package org.example.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Course {
    private int id;
    private String name;
    private String email;
    private String mobile;

}
