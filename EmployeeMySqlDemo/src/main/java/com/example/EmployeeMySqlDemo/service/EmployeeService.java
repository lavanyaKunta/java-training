package com.example.EmployeeMySqlDemo.service;

import com.example.EmployeeMySqlDemo.entity.Employee;
import com.example.EmployeeMySqlDemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public EmployeeService() {
    }

    public Employee addEmployee(Employee employee){
        Optional<Employee> emp=repo.findById(employee.getId());
        if(emp.isEmpty())
             return repo.save(employee);
        return null;
    }
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee searchEmployeeById(int id) {
        Optional<Employee> emp=repo.findById(id);
        return emp.orElse(null);
    }
    public Employee updateEmployee(Employee emp){
       return repo.save(emp);
    }

    public Employee deletingEmployee(int id){
        Employee emp=repo.findById(id).orElse(null);
        if(emp==null){
            return null;
        }
        else {
            repo.deleteById(id);
            return emp;
        }
    }


}
