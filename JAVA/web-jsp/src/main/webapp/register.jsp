<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>web jsp</title>

  <style>
    nav {
      display: flex;
      justify-content: flex-start;
      align-items: center;
      height: 35px;
      background-color: #948181;
    }

    .left{
      width: 60vw;
    }

    nav ul li a{
      text-decoration: none;
      padding: 0 10px 0 0;
    }
    nav ul li{
      list-style-type: none;
      
    }

   nav  ul  {
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .login{
      width: 300px;
    }

   
  </style>


  <script>
    function openDialog() {
      document.getElementById("dialog").showModal();
    }
    function closeDialog() {
      document.getElementById("dialog").close();
    }
  </script>
</head>

<body>
  <nav>
    <div class="left">
      <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/">Contact</a></li>
        <li><a href="/">About</a></li>
      </ul>
    </div>

    <div class="right">
      <button id="open" onclick="openDialog()">Login/Register</button>

      <dialog id="dialog" class="login">

        <form action="/" method="post" class="form">

          <input type="number" name="rollNo" id="" placeholder="Enter Roll No."><br><br>
          <input type="text" name="name" id="" placeholder="Enter your Name."><br><br>
          <input type="email" name="email" id="" placeholder="Enter Your Email."><br><br>
          <input type="tel" name="mobile" id="" placeholder="Enter your Mobile No ."><br><br>
          <input type="text" name="studyYear" id="" placeholder="Enter studu year."><br><br>

          <input type="submit" value="Register">

        </form>


<br><br>
        <button id="close" onclick="closeDialog()">Close Dialog</button>
      </dialog>
    </div>
  </nav>

  <main>

  </main>
</body>

</html>