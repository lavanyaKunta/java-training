<%@page language="java" %>
<%@ page import="com.example.EmployeeMappings.entity.Student" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

<body>

    <%
        Student student = (Student) request.getAttribute("student");
          if(student!=null) {
         %>
          <h1>student Details</h1>
      <p><strong>Student ID:</strong> ${student.studentId}</p>
       <p><strong>Student Name:</strong> ${student.studentName}</p>
       <p><strong>Age:</strong> ${student.age}</p>


       <% } else { %>
             <h2>student Id already exists!</h2>
             <h3>Try with unique Id</h3>
         <% } %>
        <br><br>
        <h4><a href="index">Home</a></h4>
</body>
</html>




