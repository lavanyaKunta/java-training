<%@page language="java" %>
<%@ page import="com.example.EmployeeMappings.entity.Student" %>

<html>
    <body>
         <%
           Student stu = (Student) request.getAttribute("stuDelete");
           if(stu!=null) {
         %>
                <h2>Successfully Deleted student</h2>

         <% } else { %>
                 <h4>The student Id is not exists to Delete<br></h4>
         <% } %>

         <br><br>
        <a href="index">Home</a>
    </body>
</html>