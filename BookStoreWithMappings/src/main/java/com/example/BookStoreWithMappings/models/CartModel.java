package com.example.BookStoreWithMappings.models;

import com.example.BookStoreWithMappings.entity.Book;
import com.example.BookStoreWithMappings.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    private int cartId;
    private List<Book> books=new ArrayList<>();
    private User user;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
