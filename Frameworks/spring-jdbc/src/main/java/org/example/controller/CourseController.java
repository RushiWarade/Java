package org.example.controller;

import org.example.model.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    public void updateCourse(Course course) {
        courseService.updateCourse(course);
    }

    public void deleteCourse(Course course) {
        courseService.deleteCourse(course);
    }


    public Course getCourseById(int id) {
        return courseService.getCourseById(id);
    }

    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

}
