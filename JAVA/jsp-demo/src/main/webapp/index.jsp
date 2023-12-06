<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>
<html>
<body>
<table style="background-color: aquamarine">
    <%for (int row = 1; row <= 10; row++) {%>
    <tr>
        <%
            for (int column = 1; column <= 30; column++) {
        %>
        <td>
            <% out.print(row * column);%>
        </td>
        <%}%>
    </tr>

    <%}%>
</table>


</body>
</html>

