package org.example.service;

import org.example.dao.CourseDao;
import org.example.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseDao courseDao ;
    public void addCourse(Course course){
        courseDao.addCourse(course);
    }

    public  void updateCourse(Course course){
        courseDao.updateCourse(course);
    }
    public  void deleteCourse(Course course){
        courseDao.deleteCourse(course);
    }

    public Course getCourseById(int id) {
      return   courseDao.getCourseById(id);
    }
    public List<Course> getAllCourse() {
     return    courseDao.getAllCourse();
    }

}
