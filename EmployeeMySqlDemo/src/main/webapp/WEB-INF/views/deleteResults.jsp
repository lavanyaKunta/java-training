<%@page language="java" %>
<%@ page import="com.example.EmployeeMySqlDemo.entity.Employee" %>

<html>
    <body>
         <%
           Employee emp = (Employee) request.getAttribute("empDelete");
           if(emp!=null) {
         %>
                <h2>Successfully Deleted Employee</h2>

         <% } else { %>
                 <h4>The Employee Id is not exists to Delete<br></h4>
         <% } %>

         <br><br>
        <a href="index">Home</a>
    </body>
</html>