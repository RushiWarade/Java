package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String getStudent() {
        return "Get Student Details";
    }

    @PostMapping("/student")
    public String createStudent() {
        return "create Student ";
    }

    @PutMapping("/student")
    public String updateStudent() {
        return "update Student Details";
    }

    @DeleteMapping("/student")
    public String deleteStudent() {
        return "delete Student Details";
    }



}
