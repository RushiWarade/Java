<%@ page import="controller.UserController" %>
<%@ page import="model.Expense" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User userData = (User) session.getAttribute("userData");
    if (userData == null) {
        response.sendRedirect("index.jsp");
    }

%>
<html>
<head>
    <title>Expense List</title>
    <%@include file="link.jsp" %>

</head>
<body>
<%@include file="nav.jsp" %>

<div class="container p-5">
    <div class="row">
        <div class="col-md-8 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Expense List</p>
                    <%
                        String ex = (String) session.getAttribute("expense");
                        if (ex != null) {
                    %> <p class="text-success text-center"><%=ex%>
                </p><%
                        session.removeAttribute("expense");
                    }
                %>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
<%--                            <th scope="col">Sr. No</th>--%>
                            <th scope="col">Title</th>
                            <th scope="col">Date</th>
                            <th scope="col">Time</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            //                            User userData = (User) session.getAttribute("userData");

                            UserController userController = new UserController();

                            List<Expense> expenseList = userController.expenseList(user);

                            for (Expense expense : expenseList) {

                        %>


                        <tr>
<%--                            <th scope="row"><%=i%>--%>
<%--                            </th>--%>
                            <td><%=expense.getTitle()%>
                            </td>
                            <td><%=expense.getDate()%>
                            </td>
                            <td><%=expense.getTime()%>
                            </td>
                            <td><%=expense.getDescription()%>
                            </td>
                            <td><%=expense.getPrice()%>
                            </td>
                            <td>
                                <a href="editExpense.jsp?edit=<%=expense.getId()%>" class="btn btn-sm me-1 btn-success">Edit</a>
                                <a href="#" class="btn btn-sm me-1 btn-danger">Delete</a>
                            </td>
                        </tr>

                        <%

                            }

                        %>

                        </tbody>
                    </table>


                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
