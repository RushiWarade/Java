<%@ page import="model.User" %>
<%@ page import="com.google.protobuf.Empty" %>
<nav class="navbar navbar-expand-lg bg-info">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Expense Tracker</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <%
                User user = (User) session.getAttribute("userData");
                if (user != null) {
            %>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home.jsp"><span
                            class="material-symbols-outlined">
              home
              </span>Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="addExpense.jsp"><span
                            class="material-symbols-outlined">library_add</span>Add Expense</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="expenseList.jsp"><span
                            class="material-symbols-outlined">
list
</span>view Expense</a>
                </li>
            </ul>

            <%
                }
            %>


            <%

                if (user == null) {
            %>

            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria - current="page" href="signup.jsp"><span
                            class="material-symbols-outlined">app_registration
                            </span> Signup </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria - current="page" href="login.jsp"><span
                            class="material-symbols-outlined">login</span> Login </a>
                </li>
            </ul>


            <%
                }
            %>

            <%

                if (user != null) {
            %>

            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria - current="page" href="editProfile.jsp"><span class="material-symbols-outlined">
account_circle
</span><%=user.getName()%>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria - current="page" href="logout"><span
                            class="material-symbols-outlined">
logout
</span>Logout </a>
                </li>
            </ul>


            <%
                }
            %>


        </div>
    </div>
</nav>