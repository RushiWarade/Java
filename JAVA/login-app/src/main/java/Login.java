import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student= new Student();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
//        writer.println(email);
//        writer.println(password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/course";
            String dbUser = "root";
            String dbPass = "123456";
            Connection   connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
                        PreparedStatement preparedStatement = connection.prepareStatement("select * from course_tbl where email=? and password = ? ");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            String emailId = null;
            String pass = null;

//            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                emailId = resultSet.getString("email");
                pass = resultSet.getString("password");
                student.setRollNo(resultSet.getString("roll_no"));
                student.setName(resultSet.getString("name"));
                student.setMobile(resultSet.getString("mobile"));
                student.setEducation(resultSet.getString("education"));
                student.setEmail(resultSet.getString("email"));



            }

            if (email.equals(emailId) && password.equals(pass)){

                RequestDispatcher dispatcher = req.getRequestDispatcher("welcome");
                dispatcher.forward(req,resp);
            }else {
                writer.println("<h3 style='color:red'> Invalid Crendintial</h3>");
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
                dispatcher.include(req,resp);

            }

            connection.close();

        } catch (ClassNotFoundException e) {
            writer.println("Class not found " + e);
        } catch (SQLException e) {
            writer.println("Connection error " + e);
        }
    }
}
