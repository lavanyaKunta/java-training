<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Admin Dashboard</h1>
     <input type="hidden" id="adminId" name="adminId" value="${adminId}" required><br>
    <form action="addBook" >
       <input type="hidden" id="adminId" name="adminId" value="${adminId}" required><br>
       <input type="submit" value="Add Book">
    </form>
    <form action="viewAdminBooks" >
           <input type="hidden" id="adminId" name="adminId" value="${adminId}" required><br>
           <input type="submit" value="View AdminBooks">
     </form>
</body>
</html>



