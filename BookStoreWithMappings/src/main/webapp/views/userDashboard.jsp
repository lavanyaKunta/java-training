<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
</head>
<body>
    <h1>User Dashboard</h1>
     <form action="viewAllBooks" >
        <input type="hidden" id="userId" name="userId" value="${userId}" required><br>
        <input type="submit" value="viewAllBooks">
      </form>
      <form action="viewCart" >
         <input type="hidden" id="userId" name="userId" value="${userId}" required><br>
         <input type="submit" value="viewCart">
      </form>
</body>
</html>



