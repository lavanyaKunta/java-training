<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Book</title>
</head>
<body>
    <h1>Increase BookQuantity</h1>
    <form action="/decreaseQuantityResult" >

        <label for="bookQuantity">Quantity:</label>
        <input type="number" id="bookQuantity" name="bookQuantity"><br>

        <input type="hidden" id="bookId" name="bookId" value="${bookId}" required>
        <input type="hidden" id="adminId" name="adminId" value="${adminId}" required>

        <input type="submit" value="decreaseQuantity">
    </form>
</body>
</html>
