<%@page language="java" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
          <h2>Employee Details Updated Successfully</h2>
                <table border="1">
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Employee Role</th>
                    </tr>
                    <tr>
                        <td>${employee.employeeName}</td>
                        <td>${employee.employeeId}</td>
                        <td>${employee.employeeRole}</td>
                    </tr>
                </table>

       <br><br>
       <h4><a href="index">Home</a></h4>


</body>
</html>
