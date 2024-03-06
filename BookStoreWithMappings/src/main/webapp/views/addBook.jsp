<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h1>Add Book</h1>
    <form action="addBookResult" >
        <label for="bookId">Book Id:</label>
        <input type="number" id="bookId" name="bookId"><br>

        <label for="bookName">Book Name:</label>
        <input type="text" id="bookName" name="bookName"><br>

        <label for="bookAuthor">Book Author:</label>
        <input type="text" id="bookAuthor" name="bookAuthor"><br>


        <label for="bookCategory">Category:</label>
        <input type="text" id="bookCategory" name="bookCategory"><br>

        <label for="bookPrice">Price:</label>
        <input type="number" id="bookPrice" name="bookPrice"><br>

        <label for="bookQuantity">Quantity:</label>
        <input type="number" id="bookQuantity" name="bookQuantity"><br>


        <input type="hidden" id="adminId" name="adminId" value="${adminId}" required><br>

        <input type="submit" value="Add Book">
    </form>
</body>
</html>
