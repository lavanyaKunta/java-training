   <%@page language="java" %>
   <%@ page import="com.example.EmployeeMappings.entity.Student" %>
   <%@ page import="com.example.EmployeeMappings.entity.Laptop" %>
   <html>
   <head>
       <title>Spring MVC Demo</title>
   </head>

   <body>

       <%
           Laptop lap = (Laptop) request.getAttribute("laptop");
             if(lap!=null) {
          %>
             <h1>Laptop Details</h1>
             <p><strong>Laptop ID:</strong><%= lap.getLaptopId() %></p>
              <p><strong>Laptop Brand:</strong> <%= lap.getBrand() %></p>
              <p><strong>Price:</strong><%= lap.getPrice() %></p>
               <p><strong>Student Id:</strong><%= lap.getPrice() %></p>
                <p><strong>Student Id:</strong> <%= student.getStudentId() %></p>
          <% } else { %>
                <h2>laptop Id already exists!</h2>
                <h3>Try with unique Id</h3>
            <% } %>
           <br><br>
           <h4><a href="index">Home</a></h4>
   </body>
   </html>




