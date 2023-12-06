import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Student student = new Student();
        String name = req.getParameter("email");
//        String name = student.getName();
        PrintWriter writer = resp.getWriter();
//        writer.println("Hello Rushi");
        writer.println("<h1 style='color:red;text-align:center;' >Welcome "+name+"</h1> ");
//        writer.println("Welcome "+name);

    }
}
