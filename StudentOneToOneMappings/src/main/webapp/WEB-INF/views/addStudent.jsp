<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>
    <h1>welcome to Employee</h1>
    <form action="/results" >
         <label for="eid">Enter Student Id:</label>
          <input type="number" id="eid" name="studentId" required><br><br>
          <label for="fname">Enter Name:</label>
          <input type="text" id="fname" name="studentName" required><br><br>
            <label for="role">Enter Age:</label>
            <input type="text" id="role" name="age" required><br><br>
          <input type="submit" value="submit">
    </form>

          <br>
          <br>
             <h4><a href="index">Home</a></h4>
</body>
</html>


