package com.example.BookStoreWithMappings.repository;

import com.example.BookStoreWithMappings.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.atomic.AtomicInteger;

public interface CartRepo  extends JpaRepository<Cart,Integer> {
}
