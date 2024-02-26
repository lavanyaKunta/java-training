<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>
    <h1>welcome to Employee</h1>
    <form action="/results" modelAttribute="studentModel">
         <label for="eid">Enter Student Id:</label>
          <input type="number" id="eid" name="studentId" required><br><br>
          <label for="name">Enter Name:</label>
          <input type="text" id="name" name="studentName" required><br><br>
            <label for="age">Enter Age:</label>
            <input type="text" id="age" name="studentAge" required><br><br>
          <input type="submit" value="submit">
    </form>

          <br>
          <br>
             <h4><a href="index">Home</a></h4>
</body>
</html>


