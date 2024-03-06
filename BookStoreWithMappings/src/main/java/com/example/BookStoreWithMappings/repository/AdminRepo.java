package com.example.BookStoreWithMappings.repository;

import com.example.BookStoreWithMappings.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{
//    Admin findByAdminUserName(String adminUserName);
}
