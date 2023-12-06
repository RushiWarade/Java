package controller;

import model.StudentModel;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentService studentService = new StudentService();

        final int rollNo = Integer.parseInt(req.getParameter("rollNo"));
        final String name = req.getParameter("name");
        final String email = req.getParameter("email");
        final int mobile = Integer.parseInt(req.getParameter("mobile"));
        final String studyYear = req.getParameter("studyYear");

        StudentModel studentModel = StudentModel.builder()
                .rollNo(rollNo)
                .name(name)
                .email(email)
                .mobile(mobile)
                .studyYear(studyYear)
                .build();
        StudentService.add(studentModel);

    }

}
