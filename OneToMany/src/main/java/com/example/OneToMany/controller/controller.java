package com.example.OneToMany.controller;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.entity.Student;
import com.example.OneToMany.service.courseService;
import com.example.OneToMany.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class controller {
    @Autowired
    studentService stuService;
    @Autowired
    courseService couService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/addStudent")
    public String student(){
        return "addStudent";
    }
    @RequestMapping("/results")
    public String studentDetails(Student stu, ModelMap model){
        Student student=stuService.addStudent(stu);
        model.addAttribute("student",student);
        return "studentDetails";
    }
    @RequestMapping("/addCourse")
    public String course(){
        return "addCourse";
    }
    @RequestMapping("/courseResults")
    public String couResults(Course cou,ModelMap model){
        Course course=couService.addCourse(cou);
        if(course!=null){
            boolean b=stuService.addCourse(course);
            System.out.println(b);
        }
        model.addAttribute("course",course);
        return "courseDetails";
    }

    @RequestMapping("/viewStudents")
    public String getAllStudents(ModelMap model){
        List<Student> students=stuService.getAllStudents();
        model.addAttribute("students",students);
        return "viewStudents";
    }
    @RequestMapping("/viewCourses")
    public String getCourses(@RequestParam("studentId") int id,ModelMap model){
        List<Course> courses=stuService.studentCourses(id);
        model.addAttribute("courses",courses);
        return "viewCourses";
    }


    @RequestMapping("/deleteResults")
    public String deleteResults(@RequestParam("studentId") int studentId, ModelMap model){
        Student stu=stuService.deletingStudent(studentId);
        model.addAttribute("stuDelete",stu);
        return "deleteResults";
    }
    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId")int courseId,ModelMap model){
        Course course=couService.deleteingCourse(courseId);
        model.addAttribute("course",course);
        return "deleteCourse";
    }
    @RequestMapping("/searchStudent")
    public String searchStudent(){
        return "searchStudent";
    }
    @RequestMapping("/searchResults")
    public String searchResult(@RequestParam("studentId")int id,ModelMap model){
        Student students=stuService.searchStudents(id);
        model.addAttribute("students",students);
        return "searchResults";
    }

    @RequestMapping("/updateStudentDetails")
    public String studentExist(@RequestParam("studentId") int id,ModelMap map){
        Student student=stuService.searchStudents(id);
        map.addAttribute("updateStudent",student);
        return "updateStudentDetails";
    }
    @RequestMapping("/updateStudentResults")
    public String updateResults(Student stu,ModelMap model){
        Student student=stuService.updateStudent(stu);
        model.addAttribute("student",student);
        return "updateStudentResults";
    }
    @RequestMapping("/updateCourseDetails")
    public String updateCourseDetails(@RequestParam("courseId")int id,ModelMap model){
        model.addAttribute("id",id);
        return "updateCourseDetails";
    }
    @RequestMapping("/updateCourseResults")
    public String updateCourseResults(Course c,ModelMap model){
        Course course=couService.updateCourse(c);
        model.addAttribute("course",course);
        return "updateCourseResults";
    }


}
