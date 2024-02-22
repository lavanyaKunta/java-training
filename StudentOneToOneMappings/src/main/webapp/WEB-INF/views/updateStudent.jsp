<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>
    <h1>update Student</h1>
    <form action="/updateStudentDetails">
         <label for="eid">Enter Student Id:</label>
          <input type="number" id="eid" name="studentId" required><br><br>
          <input type="submit" value="update">
         </form>

          <br><br>
             <h4><a href="index">Home</a></h4>
</body>
</html>