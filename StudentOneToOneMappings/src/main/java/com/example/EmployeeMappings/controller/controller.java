package com.example.EmployeeMappings.controller;

import com.example.EmployeeMappings.entity.Laptop;
import com.example.EmployeeMappings.entity.Student;
import com.example.EmployeeMappings.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class controller {
    @Autowired
    studentService service;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/addStudent")
    public String student(){
        return "addStudent";
    }
    @RequestMapping("/results")
    public String result(Student sd, ModelMap model){
        Student student=service.addStudent(sd);
        model.addAttribute("student",student);
        return "details";
    }
    @RequestMapping("/addLaptop")
    public String laptop(){
        return "addLaptop";
    }
    @RequestMapping("/laptopResults")
    public String lapResult(Laptop lap, ModelMap model){

        Laptop laptop=service.addLaptop(lap);
        model.addAttribute("laptop",laptop);
        return "laptopDetails";
    }

    @RequestMapping("/viewStudents")
    public String getAllStudents(ModelMap model){
        List<Student> students=service.getAllStudents();
        model.addAttribute("students",students);
        return "viewStudents";
    }
    @RequestMapping("/viewLaptops")
    public String getAllLaptops(ModelMap model){
        List<Laptop> laptops=service.getAllLaptops();
        model.addAttribute("laptops",laptops);
        return "viewLaptops";
    }
    @RequestMapping("/viewStudentLaptop")
    public String viewStudentLaptop(ModelMap model){
        List<Laptop> laptops=service.getStudentLaptop();
        model.addAttribute("laptops",laptops);
        return "viewStudentLaptop";
    }

    @RequestMapping("/searchStudent")
    public String searchStudent(){
        return "searchStudent";
    }
    @RequestMapping("/searchResults")
    public String searchResult(@RequestParam("studentId")int id,ModelMap model){
        Student students=service.searchStudents(id);
        model.addAttribute("students",students);
        return "searchResults";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(){
        return "deleteStudent";
    }

    @RequestMapping("/deleteResults")
    public String deleteResults(@RequestParam("studentId") int studentId, ModelMap model){
        Student stu=service.deletingStudent(studentId);
        model.addAttribute("stuDelete",stu);
        return "deleteResults";
    }
    @RequestMapping("/updateStudent")
    public String updateEmployee(){
        return "updateStudent";
    }
    @RequestMapping("/updateStudentDetails")
    public String studentExist(@RequestParam int studentId, ModelMap model){
        Student student=service.searchStudents(studentId);
        model.addAttribute("updateStudent",student);
        return "updateStudentDetails";

    }
    @RequestMapping("/updateStudentResults")
    public String updateStudentResult(Student stu,ModelMap model){
        Student student=service.updateStudent(stu);
        model.addAttribute("updateResult",student);
        return "updateStudentResults";
    }


}
