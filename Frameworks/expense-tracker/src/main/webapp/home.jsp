<%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 14-12-2023
  Time: 10:47 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="link.jsp"%>
</head>
<body>

<%@include file="nav.jsp"%>

<%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
%>
<p><%=msg%>
</p>

<%}%>
</body>
</html>
