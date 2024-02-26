package com.example.ManyToMany.controller;

import com.example.ManyToMany.entity.Course;
import com.example.ManyToMany.entity.Student;
import com.example.ManyToMany.model.CourseModel;
import com.example.ManyToMany.model.StudentModel;
import com.example.ManyToMany.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class controller {
    @Autowired
    private studentService service;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/addStudent")
    public String student(Model model){
        StudentModel studentModel=new StudentModel();
        model.addAttribute("studentModel",studentModel);
        return "addStudent";
    }
    @RequestMapping("/results")
    public String studentSave(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model){
        Student student=service.addStudent(studentModel);
        model.addAttribute("student",student);
        return "studentDetails";
    }
    @RequestMapping("/addCourse")
    public String course(Model model){
        CourseModel courseModel=new CourseModel();
        model.addAttribute("courseModel",courseModel);
        return "addCourse";
    }
    @RequestMapping("/courseResults")
    public String courseSave(@ModelAttribute("courseModel")CourseModel courseModel,ModelMap model){
        Course course=service.addCourse(courseModel);
        model.addAttribute("course",course);
        return "courseDetails";
    }
    @RequestMapping("/viewStudents")
    public String getAllStudents(ModelMap map){
        List<Student> students=service.getAllStudents();
        map.addAttribute("students",students);
        return "viewStudents";
    }
    @RequestMapping("/viewCourses")
    public String getCourses(ModelMap map){
        List<Course> courses=service.getAllCourses();
        map.addAttribute("courses",courses);
        return "viewCourses";
    }
    @RequestMapping("/addCourseToStudent")
    public String addCourseToStudent(@RequestParam("studentId")int id,ModelMap map)
    {
        map.addAttribute("id",id);
        return "addCourseToStudent";
    }
    @RequestMapping("/addToStudentList")
    public String addtoList(@RequestParam("courseId")int cid,@RequestParam("studentId")int sid, ModelMap map){
        Course course=service.searchCourse(cid);
        if(course!=null) {
            String str = service.addToList(cid, sid);
            map.addAttribute("msg",str);
        }
        else{
            map.addAttribute("msg","course not registered");
        }
        return "redirect:/viewStudents";
    }
    @RequestMapping("/addStudentToCourse")
    public String addStudentToCourse(@RequestParam("courseId") int cid,ModelMap mp){
        mp.addAttribute("cid",cid);
        return "addStudentToCourse";
    }
    @RequestMapping("/addStudentToCourseResult")
    public String addStudentToCourseResult(@RequestParam("studentId")int sid,@RequestParam("courseId")int cid,ModelMap mp){
        Student student=service.searchStudent(sid);
        if(student!=null){
            String str=service.addStudentToCourse(sid,cid);
            mp.addAttribute("msg",str);
        }
        else{
            mp.addAttribute("msg","student not registered");
        }
        return "redirect:/viewCourses";
    }

    @RequestMapping("/viewStudentCourses")
    public String getCourses(@RequestParam("studentId") int id,ModelMap model){
        List<Course> courses=service.getStudentCourses(id);
        model.addAttribute("courses",courses);
        model.addAttribute("id",id);
        return "viewStudentCourses";
    }
    @RequestMapping("/viewCourseStudents")
    public String getStudents(@RequestParam("courseId") int id,ModelMap model){
        List<Student> students=service.getCourseStudents(id);
        model.addAttribute("students",students);
        return "viewStudents";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudentResults(@RequestParam("studentId") int studentId, ModelMap model){
        service.deletingStudent(studentId);
        return "redirect:/viewStudents";
    }
    @RequestMapping("/deleteCourse")
    public String deleteCourseResults(@RequestParam("courseId") int courseId, ModelMap model){
        service.deletingCourse(courseId);
        return "redirect:/viewCourses";
    }
    @RequestMapping("/deleteCourseOfStudent")
    public String deleteStudentCourse(@RequestParam("studentId") int sid,@RequestParam("courseId") int cid){
        service. deleteCourseOfStudent(sid,cid);
        return "redirect:viewStudents";
    }

    @RequestMapping("/updateStudentDetails")
    public String studentExist(@RequestParam("studentId") int id,ModelMap map){
        Student student=service.searchStudents(id);
        map.addAttribute("updateStudent",student);
        return "updateStudentDetails";
    }
    @RequestMapping("/updateStudentResults")
    public String updateResults(Student stu,ModelMap model){
        Student student=service.updateStudent(stu);
        model.addAttribute("student",student);
        return "redirect:/viewStudents";
    }
    @RequestMapping("/updateCourseDetails")
    public String courseExist(@RequestParam("courseId") int id,ModelMap map){
        Course course=service.searchCourse(id);
        map.addAttribute("course",course);
        return "updateCourseDetails";
    }
    @RequestMapping("/updateCourseResults")
    public String updateCourseResults(Course cou,ModelMap model){
        Course course=service.updateCourse(cou);
        model.addAttribute("course",course);
        return "redirect:/viewCourses";
    }




}
