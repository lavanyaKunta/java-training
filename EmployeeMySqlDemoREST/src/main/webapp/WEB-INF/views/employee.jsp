<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>
    <h1>welcome to Employee</h1>
    <form action="/results" >
         <label for="eid">Enter employee Id:</label>
          <input type="number" id="eid" name="employeeId" required><br><br>
          <label for="fname">Enter FirstName:</label>
          <input type="text" id="fname" name="employeeName" required><br><br>
            <label for="role">Enter role:</label>
            <input type="text" id="role" name="employeeRole" required><br><br>
          <input type="submit" value="submit">
    </form>

          <br><br>
             <h4><a href="index">Home</a></h4>
</body>
</html>


