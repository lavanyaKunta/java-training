package com.example.BookStoreWithMappings.service;

import com.example.BookStoreWithMappings.entity.Admin;
import com.example.BookStoreWithMappings.entity.User;
import com.example.BookStoreWithMappings.models.UserModel;
import com.example.BookStoreWithMappings.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User userRegister(UserModel userModel){
        User user=new User();
        BeanUtils.copyProperties(userModel,user);
        User u= userRepo.findById(user.getUserId()).orElse(null);
        if(u==null){
            user.setUserId(user.getUserId());
            user.setPassword(user.getPassword());
            return userRepo.save(user);
        }
        return null;
    }
    public boolean authenticate(int userId,String password){
        User user=userRepo.findById(userId).orElse(null);
        if(user!=null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public User searchUser(int userId) {
        return userRepo.findById(userId).orElse(null);
    }
}
