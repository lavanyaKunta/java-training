<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Book</title>
</head>
<body>
    <h1>Buy Book</h1>
    <form action="/buyBookResult" >

        <label for="bookQuantity">Quantity:</label>
        <input type="number" id="bookQuantity" name="bookQuantity"><br>

        <input type="hidden" id="bookId" name="bookId" value="${bookId}" required>
        <input type="hidden" id="userId" name="userId" value="${userId}" required>
        <input type="hidden" id="cartId" name="cartId" value="${cartId}" required>

        <input type="submit" value="Buy">
    </form>
</body>
</html>
