<%@page language="java" %>
<%@ page import="com.example.OneToMany.entity.Student" %>

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

         <br>
         <a href="viewStudents">viewStudents</a>
         <br>
        <a href="index">Home</a>
    </body>
</html>