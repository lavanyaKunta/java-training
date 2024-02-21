<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>
    <h1>update Employee</h1>
    <form action="/updateEmployeeDetails">
         <label for="eid">Enter employee Id:</label>
          <input type="number" id="eid" name="employeeId" required><br><br>
          <input type="submit" value="update">
         </form>

          <br><br>
             <h4><a href="index">Home</a></h4>
</body>
</html>