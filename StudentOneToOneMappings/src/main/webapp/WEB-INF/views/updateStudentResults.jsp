<%@page language="java" %>
<%@page import="com.example.EmployeeMappings.entity.Student" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
          <h2>Student Details Updated Successfully</h2>
          <%
              Student student = (Student) request.getAttribute("updateResult");
               %>
                <table border="1">
                    <tr>
                        <th>Student Id</th>
                        <th>Student Name</th>
                        <th>Student Age</th>
                    </tr>
                    <tr>
                        <td><%= student.getStudentId() %></td>
                        <td><%= student.getStudentName() %></td>
                        <td><%= student.getAge() %></td>
                    </tr>
                </table>



       <br><br>
       <h4><a href="index">Home</a></h4>


</body>
</html>
