package com.example.BookStoreWithMappings.repository;

import com.example.BookStoreWithMappings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Integer> {
//    User findByUserName(String userName);
}
