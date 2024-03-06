package com.example.BookStoreWithMappings.repository;

import com.example.BookStoreWithMappings.entity.Admin;
import com.example.BookStoreWithMappings.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
