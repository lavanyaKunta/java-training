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

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService service;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/addEmployee")
    public String addEmployee(){
        System.out.println("adding employee");
        return "employee";
    }
    @RequestMapping("/results")
    public String results(Employee emp,ModelMap model){
        Employee employee=service.addEmployee(emp);
        System.out.println(employee);
        model.addAttribute("E",employee);
        return "details";
    }
    @RequestMapping("/viewEmployees")
    public String getAllEmployees(ModelMap model){
        System.out.println("employee view list");
        List<Employee> employees=service.getAllEmployees();
        model.addAttribute("employees",employees);
        return "viewEmployees";
    }
    @RequestMapping("/searchEmployee")
    public String searchEmployee(){
        System.out.println("search");
        return "searchEmployee";
    }
    @RequestMapping("/searchEmployeeResults")
    public String searchEmployeeResults(@RequestParam int employeeId, ModelMap model) {
        Employee employee =  service.searchEmployeeById(employeeId);
        model.addAttribute("EmployeeSearch", employee);
        System.out.println("searchinggg..");
        return "searchEmployeeResults";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(){
        return "updateEmployee";
    }
    @RequestMapping("/updateEmployeeDetails")
    public String employeeExist(@RequestParam int employeeId, ModelMap model){
        Employee employee=service.searchEmployeeById(employeeId);
        model.addAttribute("updateEmployee",employee);
        return "updateEmployeeDetails";

    }
    @RequestMapping("/updateEmployeeResults")
    public String updateEmployeeResult(Employee emp,ModelMap model){
        Employee employee=service.updateEmployee(emp);
        model.addAttribute("updateRes",employee);
        return "updateEmployeeResults";
    }


    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(){
        return "deleteEmployee";
    }
    @RequestMapping("/deleteResults")
    public String deleteResults(@RequestParam("employeeId") int employeeId,ModelMap model){
        Employee emp=service.deletingEmployee(employeeId);
        model.addAttribute("empDelete",emp);
        return "deleteResults";
    }


}
