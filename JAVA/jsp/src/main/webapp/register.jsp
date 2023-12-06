<%@ page import="java.io.Writer" %>
<%@ page import="java.sql.*" %>


<%
    final String rollNo = request.getParameter("rollNo");
    final String name = request.getParameter("name");
    final String email = request.getParameter("email");
    final String mobile = request.getParameter("mobile");
    final String studyYear = request.getParameter("studyYear");
    final String pass = request.getParameter("pass");

    Writer writer = response.getWriter();


    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "123456");

//        final PreparedStatement preparedStatement1 = connection.prepareStatement("select email from course_tbl where email=?");
//        preparedStatement1.setString(1,email);
//        final ResultSet resultSet = preparedStatement1.executeQuery();
//
//        String emailCheck = null;
//        while (resultSet.next()){
//            emailCheck = resultSet.getString(email);
//        }
//
//        if (emailCheck == email) {
//            out.println("Email already exist....");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
//            requestDispatcher.include(request, response);
//        } else {

            final PreparedStatement preparedStatement = connection.prepareStatement("insert into course_tbl(roll_no,name,mobile,education,email,password) values(?,?,?,?,?,?) ");

            preparedStatement.setString(1, rollNo);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, mobile);
            preparedStatement.setString(4, studyYear);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, pass);


            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                out.println("Registration Success....");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.include(request, response);
            } else {
                out.println("Something wrong...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.include(request, response);
            }
//        }
    } ca.
        tch (ClassNotFoundException e) {
        out.println("file not found " + e);
    } catch (SQLException e) {
        out.println("Error in connection" + e);
    }


//    out.println(rollNo + "\t" + name + "\t" + mobile + "\t" + studyYear + "\t" + email + "\t" + pass);
%>
