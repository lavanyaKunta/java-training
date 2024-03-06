package com.example.BookStoreWithMappings.repository;

import com.example.BookStoreWithMappings.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
}
