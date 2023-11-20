import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@Webservlet()
@WebServlet("/show")
public class ShowInfo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servise method");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("Rushi");


        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itshala", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from course");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                writer.print(resultSet.getInt(1)+ "\t");
                writer.print(resultSet.getString(2)+ "\t");
                writer.print(resultSet.getString(3)+ "\t");
                writer.print(resultSet.getString(4)+ "\t");
                writer.print(resultSet.getString(5)+ "\t");
                writer.print(resultSet.getString(6)+ "\t");
                writer.print(resultSet.getString(7)+ "\t");
                writer.print(resultSet.getString(8)+ "\t");
                writer.println();
            }


            connection.close();

        } catch (ClassNotFoundException e) {
            writer.println("Fail to load driver" + e);
//            System.out.println("Fail to load driver" + e);
        } catch (SQLException e) {
            writer.println("Connection error" + e);
//            System.out.println("Connection error" + e);
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
