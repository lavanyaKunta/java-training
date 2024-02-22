package com.example.EmployeeMappings.service;

import com.example.EmployeeMappings.entity.Laptop;
import com.example.EmployeeMappings.repo.laptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class laptopService {
    @Autowired
    private laptopRepo lapRepo;
    public void laptopService() {

    }




    public List<Laptop>getStudentLaptop(){
        List<Laptop> laptop=lapRepo.findAll();
        List<Laptop> lap=laptop.stream().filter(l->l.getStudent()!=null).collect(Collectors.toList());
        return lap;
    }
}
