<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>dynammic web project</title>
</head>
<body>
<table>
    <form action="/web-app/insertData" method="post">
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name" required></td>
        </tr>
        <tr>
            <td><label for="email">Email</label></td>
            <td><input type="email" name="email" id="email"></td>
        </tr>
        <tr>
            <td><label for="mobile">Mobile No.</label></td>
            <td><input type="tel" name="mobile" id="mobile"></td>
        </tr>
        <tr>
            <td><label for="address">Address</label></td>
            <td><input type="text" name="address" id="address"></td>
        </tr>
        <tr>
            <td><label for="qualification">Qualification</label></td>
            <td><input type="text" name="qualification" id="qualification"></td>
        </tr>
        <tr>
            <td><label for="percentage">Percentage</label></td>
            <td><input type="text" name="percentage" id="percentage"></td>
        </tr>
        <tr>
            <td><label for="course">Course</label></td>
            <td><select name="course" id="course" required>
                <!--                <option >Select</option>-->
                <option value="Full Stack Java">Full Stack Java</option>
                <option value="Full Stack Java with React">Full Stack Java With React</option>
                <option value="Full Stack Python">Full Stack Python</option>
                <option value="Data Science">DataScience</option>
            </select></td>
        </tr>
        <tr>
            <!--            <td><input type="submit" value="Submit"></td>-->
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </form>

</table>


</body>
</html>