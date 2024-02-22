<%@ page language="java" %>
<%@page import="com.example.EmployeeMappings.entity.Student" %>
<%@page import="com.example.EmployeeMappings.entity.Laptop" %>


<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <%
         Student student = (Student) request.getAttribute("students");
            if (student!=null) {
            Laptop lap=student.getLaptop();
        %>
            <h2>Student Details</h2>
            <table>
             <tr>
                 <th>Student Id</th>
                 <td><%= student.getStudentId() %></td>
             </tr>
            <tr>
                <th>Student Name</th>
                <td><%= student.getStudentName() %></td>
            </tr>

            <tr>
                <th>Student Age</th>
                <td><%= student.getAge() %></td>
            </tr>
            <tr>
              <th>Laptop Id</th>
               <td><%= lap != null ? lap.getLaptopId() : "N/A" %></td>
              </tr>
              <tr>
                <th>Laptop Brand</th>
                <td><%= lap != null ? lap.getBrand() : "N/A" %></td>
                 </tr>
     <tr>
                   <th>Lap Price</th>
                    <td><%= lap != null ? lap.getPrice() : "N/A" %></td>
                   </tr>


        </table>
            <br>

        <% } else { %>
            <h2>The Student Id not Exists</h2>

                 <br><br>
        <% } %>
        <br>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
