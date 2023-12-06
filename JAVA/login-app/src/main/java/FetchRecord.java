import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/update")
public class FetchRecord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        int rollno = Integer.parseInt(req.getParameter("rollno"));


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from course_tbl where roll_no=?");
            preparedStatement.setInt(1,rollno);
            ResultSet resultSet = preparedStatement.executeQuery();

            int roll_no = 0;
            String name = null;
            String mobile = null;
            String email = null;
            String education = null;


            while (resultSet.next()){
                roll_no = Integer.parseInt(resultSet.getString("roll_no"));
                name= resultSet.getString("name");
                mobile= resultSet.getString("mobile");
                email= resultSet.getString("email");
                education= resultSet.getString("education");
            }

//            writer.println(roll_no);
//            writer.println(name);
//            writer.println(email);
//            writer.println(mobile);
//            writer.println(education);


            writer.println("<form action='updateRecord' method='post'>");
            writer.println("<label for='rollNo'>Roll No</label>");
            writer.println("<input type='number' name='urollNo' id='rollNo' readonly  value= "+roll_no+"  >");

            writer.println("<label for='name'>Name</label>");
            writer.println("<input type='text' name='uname' id='name' value= "+name+">");

            writer.println("<label for='email'>Email</label>");
            writer.println("<input type='email' name='uemail' id='email' value= "+email+">");

            writer.println("<label for='mobile'>Mobile No</label>");
            writer.println("<input type='tel' name='umobile' id='mobile' value= "+mobile+">");

            writer.println("<label for='education'>Education</label>");
            writer.println("<input type='text' name='ueducation' id='education' value= "+education+">");

            writer.println("<input type='submit' value='Update Record' >");

            writer.println("</form>");
        } catch (ClassNotFoundException e) {
            writer.println("Class  not found "+e);
        } catch (SQLException e) {
            writer.println("Connection error "+e);
        }
    }
}
