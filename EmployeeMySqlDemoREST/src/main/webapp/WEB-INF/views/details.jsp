<%@page language="java" %>
<%@ page import="com.example.EmployeeMySqlDemo.entity.Employee" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

<body>

    <%
        Employee emp = (Employee) request.getAttribute("E");
          if(emp!=null) {
         %>
          <h1>employees Details</h1>
      <p><strong>Employee ID:</strong> ${employee.employeeId}</p>
       <p><strong>Employee Name:</strong> ${employee.employeeName}</p>
       <p><strong>Role:</strong> ${employee.employeeRole}</p>


       <% } else { %>
             <h2>The Employee Id already exists!</h2>
             <h3>Try with unique Id</h3>
         <% } %>
        <br><br>
        <h4><a href="index">Home</a></h4>
</body>
</html>




