package com.example.BookStoreWithMappings.service;

import com.example.BookStoreWithMappings.entity.Admin;
import com.example.BookStoreWithMappings.models.AdminModel;
import com.example.BookStoreWithMappings.repository.AdminRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    public Admin adminRegister(int adminId,String adminPassword){
        Admin admin=new Admin(adminId,adminPassword);
        Admin ad= adminRepo.findById(admin.getAdminId()).orElse(null);
        if(ad==null){

            return adminRepo.save(admin);
        }
        System.out.println(admin);
        return null;
    }
    public boolean authenticate(int adminId,String password){
        Admin admin= adminRepo.findById(adminId).orElse(null);
        if(admin!=null && password.equals(admin.getAdminPassword())){
            return true;
        }
        return false;
    }
}
