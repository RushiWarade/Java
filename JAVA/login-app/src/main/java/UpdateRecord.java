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

@WebServlet("/updateRecord")
public class UpdateRecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        int rollNo = Integer.parseInt(req.getParameter("urollNo"));
        req.getParameter("uname");
        String email = req.getParameter("uemail");
        String mobile = req.getParameter("umobile");
        String education = req.getParameter("ueducation");

//        writer.println(name);
//        writer.println(rollNo);
//        writer.println(email);
//        writer.println(mobile);
//        writer.println(education);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/course";
            String dbUser = "root";
            String dbPass = "123456";
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            PreparedStatement preparedStatement = connection.prepareStatement("update  course_tbl set name = ? , mobile = ? , education = ? , email = ? where roll_no=? ");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mobile);
            preparedStatement.setString(3, education);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, rollNo);
//            preparedStatement.setString(6, pass);

//            final boolean execute = preparedStatement.execute();

            int i = preparedStatement.executeUpdate();

            if (i>0) {
                writer.println("<h2 style='color:green;' >Record Updated Successfully...!</h2>");
                RequestDispatcher dispatcher = req.getRequestDispatcher("update.html");
                dispatcher.include(req, resp);
            } else {
                writer.println("Something Wrong..");
                RequestDispatcher dispatcher = req.getRequestDispatcher("udtate.html");
                dispatcher.include(req, resp);
            }
        } catch (ClassNotFoundException e) {
            writer.println("Class not found " + e);
        } catch (SQLException e) {
            writer.println("Error in Connection" + e);
        }


    }
}
