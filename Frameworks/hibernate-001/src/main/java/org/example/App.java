package org.example;

import org.example.controller.Controller;
import org.example.model.Course;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Controller controller = new Controller();

//        Add data
       /* Course course= Course.builder()
                .name("Saurabh")
                .email("saurabh@gmail.com")
                .mobile("876757678")
                .build();
        controller.add(course);*/



//        update data
       /* Course course = Course.builder()
                .id(1)
                .name("Rushi Warade")
                .email("rushiwarade023@gmail.com")
                .mobile("9075063779")
                .build();
        controller.update(course);*/


//        get course
//        controller.get(1);


//        Delete course
        controller.delete(1);

    }
}
