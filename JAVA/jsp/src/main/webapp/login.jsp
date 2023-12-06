<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 26-11-2023
  Time: 10:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    final String email = request.getParameter("email");
    final String pass = request.getParameter("pass");

//    out.println(email);
//    out.println(pass);

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course","root","123456");

        final PreparedStatement preparedStatement = connection.prepareStatement("select * from course_tbl where email=? and  password=?");

        preparedStatement.setString(1,email);
        preparedStatement.setString(2,pass);


        final ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.)


    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }catch (SQLException e){
        out.println("Error in Connection"+e);
    }

%>
</body>
</html>
