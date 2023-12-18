package servlets;

import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();

        User user = User.builder()
                .name(name)
                .email(email)
                .mobile(mobile)
                .address(address)
                .password(password)
                .build();

//        writer.println(user);


        UserController userController = new UserController();

        boolean b = userController.addUser(user);

//        writer.println(b);
        HttpSession session = req.getSession();
        if (b){
            session.setAttribute("msg","Registration Success.. Login Now.!");
            resp.sendRedirect("login.jsp");
        }else {
            session.setAttribute("msg","Something wrong.!");
            resp.sendRedirect("signup.jsp");
        }
    }
}
