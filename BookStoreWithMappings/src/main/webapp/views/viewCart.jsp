<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.BookStoreWithMappings.entity.Cart" %>
<%@page import="com.example.BookStoreWithMappings.entity.Book" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
</head>
<body>

<h2>User Cart</h2>

<table border="1">
    <thead>
        <tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Price</th>
            <th>PlaceOrder</th>
        </tr>
    </thead>
    <tbody>
            <%    List<Book> bookList=(List<Book>) request.getAttribute("cartList");

             for (Book book : bookList) {  %>
            <tr>
                <td><%= book.getBookId() %></td>
                <td><%= book.getBookName() %></td>
                <td><%= book.getBookAuthor() %></td>
                <td><%= book.getBookCategory() %></td>
                <td><%= book.getBookPrice() %></td>
                 <td><form action="/buyBook">
                     <input type="hidden" name="userId" value="${userId}" >
                     <input type="hidden" name="bookId" value="<%= book.getBookId() %>" >
                     <input type="hidden" name="cartId" value="${cartId}" >
                     <input type="submit" value="BuyBook"></form>
                 </td>
               </tr>
               <% } %>

               <h3> <a href="index">Home</a></h3>
    </body>
</table>

</body>
</html>
