import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //get input data
        int rollno = Integer.parseInt(req.getParameter("roll_no"));
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String education = req.getParameter("education");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");


        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

//        writer.println(rollno + "\t" + name + "\t" + mobile + "\t" + education + "\t" + email);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/course";
            String dbUser = "root";
            String dbPass = "123456";
           Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into course_tbl(roll_no,name,mobile,education,email,password) values(?,?,?,?,?,?) ");

            preparedStatement.setInt(1, rollno);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, mobile);
            preparedStatement.setString(4, education);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, pass);

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                writer.println("<h2 style='color:green;' >Registered  Successfully... you are login now!</h2>");
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
                dispatcher.include(req, resp);
            } else {
                writer.println("Registration failed..");
                RequestDispatcher dispatcher = req.getRequestDispatcher("register.html");
                dispatcher.include(req, resp);
            }
        } catch (ClassNotFoundException e) {
            writer.println("Class not found " + e);
        } catch (SQLException e) {
            writer.println("Error in Connection" + e);
        }


    }
}
