import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/insertData")
public class InsertData implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        PrintWriter writer = servletResponse.getWriter();
        Connection connection = null;

        String name = servletRequest.getParameter("name");
        String email = servletRequest.getParameter("email");
        String mobile = servletRequest.getParameter("mobile");
        String address = servletRequest.getParameter("address");
        String qualification = servletRequest.getParameter("qualification");
        String percentage = servletRequest.getParameter("percentage");
        String course = servletRequest.getParameter("course");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/itshala","root","123456");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into course(name,email,mobile,address,qualification,percentage,courseName) values(?,?,?,?,?,?,?) ");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,mobile);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,qualification);
            preparedStatement.setString(6,percentage);
            preparedStatement.setString(7,course);

            int i = preparedStatement.executeUpdate();


            if (i>0){
                writer.println("Data inserted Successfully....!");
//                servletResponse.Send
            }else{
                writer.println("Data not inserted");
            }


        } catch (SQLException e) {
            writer.println("Exception in Connection"+e);
        } catch (ClassNotFoundException e) {
            writer.println("Exception in Class Load "+e);
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
