<!DOCTYPE html>
<html>
<head>
    <title> SignUp and Login</title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="signup" method="post">
            <h1 style="padding-top: 15px"> Create Account</h1>
            <input type="text" name="fname" placeholder="First Name">
            <input type="text" name="lname" placeholder="Last Name">
            <input type="text" name="mobile" placeholder="Phone Number">
            <input type="text" name="address" placeholder="Address">
            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <button style="margin-top:10px" type="submit"> Create Account</button>
            <h5>Already have an account! <a class="ghost" id="signIn" style="color:blue;"><u>Sign In</u></a></h5>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="login" method="post">
            <h1 style="padding-bottom: 15px"> Login Now</h1>
            <%
                String msg = (String) session.getAttribute("msg");
                if (msg != null) {
            %>
            <p style="color: green; font-family: Serif; font-size: 20px"><%=msg%>
            </p>

            <% }
                session.removeAttribute("msg");
            %>

            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <a href="#" style="padding-left:150px; font-weight: bold"> Forgot Your Password?</a>
            <button style="margin-top: 10px" type="submit"> Let Me In...</button>
            <h5>New to here! <a class="ghost" id="signUp" style="color:blue;"><u>Sign Up</u></a></h5>
        </form>

    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <%--               <img src="https://www.nacionrex.com/__export/1570213049857/sites/debate/img/2019/10/04/joker_estreno_fbi_vigilancia_redes_sociales_espionaje_2019_crop1570212801819.jpg_423682103.jpg"&ndash;%&gt;--%>
                <%--                alt="movie-1" height="480" width="500"/--%>
                <img src="signup.avif"
                     alt="movie-1" height="480" width="500"/>--%>


            </div>
            <div class="overlay-panel overlay-right">
                <%--                <img src="https://i.pinimg.com/originals/b8/e1/b6/b8e1b67a3f203dac4bc4602339e534a3.jpg" alt="movie-2"--%>
                <%--                     height="480" width="500"/>--%>

                <img src="login.avif"
                     alt="movie-1" height="480" width="500"/>--%>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });
    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
</script>
</body>
</html>
