package com.example.BookStoreWithMappings.models;

import com.example.BookStoreWithMappings.entity.Book;
import com.example.BookStoreWithMappings.entity.User;
import jakarta.persistence.OneToOne;

public class OrderModel {
    private Book book;
    private int quantity;
    @OneToOne
    private User user;
}
