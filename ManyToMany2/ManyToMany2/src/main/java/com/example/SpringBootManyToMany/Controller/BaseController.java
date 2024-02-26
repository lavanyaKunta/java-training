package com.example.SpringBootManyToMany.Controller;

import com.example.SpringBootManyToMany.Models.CourseModel;
import com.example.SpringBootManyToMany.Models.StudentModel;
import com.example.SpringBootManyToMany.Services.CourseServices;
import com.example.SpringBootManyToMany.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private StudentServices studentServices;
    @Autowired
    private CourseServices courseServices;
    @RequestMapping("home")
    public String home(){
        return "home";
    }
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @RequestMapping("/addStudentResult")
    public String addStudentResult(StudentModel student, ModelMap mp){
        StudentModel s=studentServices.saveStudent(student);
        mp.addAttribute("student",s);
        System.out.println(s);
        return "redirect:/viewStudent";

    }
    @RequestMapping("/addCourses")
    public String addCourses(){
        return "addCourses";
    }

    @RequestMapping("/addResultCourses")
    public String addResultCourses(CourseModel course,ModelMap mp){
        CourseModel c=courseServices.saveCourse(course);
        mp.addAttribute("course",c);
        System.out.println(c);

        return "redirect:/viewCourses";
    }

    @RequestMapping("/viewStudent")
    public String viewStudent(ModelMap mp){
        List<StudentModel> studentList=studentServices.getAllStudents();
        mp.addAttribute("studentList",studentList);
        return "viewStudents";

    }
    @RequestMapping("/viewCourses")
    public String  viewCourses(ModelMap mp){
        List<CourseModel> courseList=courseServices.getAllCourses();
        mp.addAttribute("coursesList",courseList);
        return "viewCourses";
    }
    @RequestMapping("/viewStudnetCourses")
    public String viewStudnetCourses(@RequestParam("id") int id,ModelMap mp){
        List<CourseModel> CourseList=studentServices.getAllCourses(id);
        //System.out.println(CourseList);
        mp.addAttribute("coursesList",CourseList);
        mp.addAttribute("id",id);
        return "viewStudnetCourses";
    }
    @RequestMapping("/viewCoursesStudent")
    public String viewCoursesStudent(@RequestParam("CourseId") int id,ModelMap mp){
        List<StudentModel> studentModelList=courseServices.getAllStudents(id);
      //  System.out.println(studentModelList);
        mp.addAttribute("studentList",studentModelList);
        mp.addAttribute("cid",id);
        return "viewCoursesStudent";
    }

    @RequestMapping("/AddCoursesToStudent")
    public String AddCoursesToStudent(@RequestParam("id") int id,ModelMap mp){
        mp.addAttribute("id",id);
        return "AddCoursesToStudentForm";
    }
    @RequestMapping("/AddCoursesToStudentResult")
    public String AddCoursesToStudentResult(@RequestParam("id") int id, @RequestParam("courseId") int courseId, ModelMap mp){
        CourseModel course=courseServices.searchCourse(courseId);
        if(course!=null){
            String str;

            str=studentServices.addCourse(id,course);
            System.out.println(str);
            mp.addAttribute("msg",str);

        }
        else{
            mp.addAttribute("msg","course Id is not Registered");
        }
        return "redirect:/viewStudent";
    }
    @RequestMapping("/addStudentToCourse")
    public String addStudentToCourse(@RequestParam("CourseId") int id,ModelMap mp){
        mp.addAttribute("cid",id);
        return "addStudentToCourseForm";
    }
    @RequestMapping("/addStudentToCourseResult")
    public String addStudentToCourseResult(@RequestParam("id") int id,@RequestParam("cid") int cid,ModelMap mp){
        StudentModel student=studentServices.searchStudent(id);
        CourseModel course=courseServices.searchCourse(cid);

       // System.out.println(student);
        if(student!=null){
            String str=studentServices.addCourse(id,course);
            //System.out.println(str);
        }
        return "redirect:/viewCourses";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id){
        String str=studentServices.deleteStudent(id);
        System.out.println(str);
        return "redirect:/viewStudent";
    }
    @RequestMapping("/deleteCourseOfStudent")
    public String deleteCourseOfStudent(@RequestParam("id") int id,@RequestParam("CourseId") int cid){
        studentServices.deleteCourseOfStudent(id,cid);
        return "redirect:viewStudent";

    }
    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("CourseId") int id){
        String str=studentServices.deleteCourse(id);
        String string=courseServices.deleteCourse(id);
        System.out.println(str);
        return "redirect:/viewCourses";
    }
    @RequestMapping("/deleteStudentOfCourse")
    public String deleteStudentOfCourse(@RequestParam("id") int id,@RequestParam("cid") int cid){
        studentServices.deleteCourseOfStudent(id,cid);

       // courseServices.deleteStudentOfCourse
        return "redirect:/viewCourses";

    }
}
