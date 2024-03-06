package com.example.EmployeeMySqlDemo.controller;

import com.example.EmployeeMySqlDemo.entity.Employee;
import com.example.EmployeeMySqlDemo.repo.EmployeeRepo;
import com.example.EmployeeMySqlDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

//    @RequestMapping("/index")
//    public String index(){
//        return "index";
//    }
    @PostMapping("addEmployee")
    public void addEmployeee(@RequestBody Employee emp){
          service.addEmployeee(emp);

    }
    @GetMapping("viewEmployees")
    //@ResponseBody
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }
//    @GetMapping("/searchEmployee/1")
//    public Employee searchEmployee(){
//        return service.searchEmployeeById(1);
//    }
    @GetMapping("/searchEmployee/{employeeId}")
    public Employee searchEmployee(@PathVariable("employeeId")int employeeId){
        return service.searchEmployeeById(employeeId);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee emp){
       service.updateEmployee(emp);
       return service.searchEmployeeById(emp.getId());
    }

    @RequestMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
       service.deletingEmployee(employeeId);
        return "deleted";
    }


}
