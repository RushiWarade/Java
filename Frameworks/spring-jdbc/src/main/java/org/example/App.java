package org.example;

import org.example.Configuration.SpringConfig;
import org.example.controller.CourseController;
import org.example.dao.CourseDao;
import org.example.model.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        CourseController courseController = applicationContext.getBean(CourseController.class);
//        CourseDao courseDao = applicationContext.getBean(CourseDao.class);
//        Course course = Course.builder().id(202).name("Rushi warade").email("rushi123@gmail.com").mobile("9545826726").build();
//        courseController.addCourse(course);
//        courseController.updateCourse(course);

//        courseController.deleteCourse(course);


        System.out.println(courseController.getCourseById(23));

        System.out.println(courseController.getAllCourse());

    }
}
