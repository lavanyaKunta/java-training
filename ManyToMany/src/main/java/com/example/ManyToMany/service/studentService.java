package com.example.ManyToMany.service;

import com.example.ManyToMany.entity.Course;
import com.example.ManyToMany.entity.Student;
import com.example.ManyToMany.model.CourseModel;
import com.example.ManyToMany.model.StudentModel;
import com.example.ManyToMany.repo.courseRepo;
import com.example.ManyToMany.repo.studentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class studentService {
    @Autowired
    studentRepo stuRepo;
    @Autowired
    courseRepo couRepo;
    public Student addStudent(StudentModel studentModel){
        Student student=new Student();
        BeanUtils.copyProperties(studentModel,student);
        Optional<Student> stu=stuRepo.findById(student.getStudentId());
        if(stu.isEmpty()){
            return stuRepo.save(student);
        }
        return null;
    }
    public Course addCourse(CourseModel courseModel){
        Course course=new Course();
        BeanUtils.copyProperties(courseModel,course);
        Optional<Course> cou=couRepo.findById(course.getCourseId());
        if(cou.isEmpty()){
            return couRepo.save(course);
        }
        return null;
    }
    public List<Student> getAllStudents(){
        List<Student> studentList=stuRepo.findAll();
        return studentList;
    }
    public List<Course> getAllCourses(){
        List<Course> courseList=couRepo.findAll();

        return courseList;
    }
    public Student searchStudents(int id) {
        Optional<Student> stu=stuRepo.findById(id);
        return stu.orElse(null);
    }

    public List<Course> getStudentCourses(int id){
        Student stu=stuRepo.findById(id).orElse(null);
        List<CourseModel> courseModelList=new ArrayList<>();
        if(stu!=null){
            List<Course> courseList=stu.getCourses();
            courseList.forEach(c->{});
        }
        return stu.getCourses();
    }
    public List<Student> getCourseStudents(int id){
        Course cou=couRepo.findById(id).orElse(null);
        return cou.getStudents();
    }
    public Course searchCourse(int id) {
        Optional<Course> stu=couRepo.findById(id);
        return stu.orElse(null);
    }
    public Student searchStudent(int id) {
        Optional<Student> cou=stuRepo.findById(id);
        return cou.orElse(null);
    }

    public String addToList(int cid, int sid){
        Student s=searchStudents(sid);
        Course c=searchCourse(cid);
        if(c!=null) {
            List<Course> course = s.getCourses();
            course.add(c);
            stuRepo.save(s);
            System.out.println("Added");
            return "course added";
        }
        return "course not rigistered" ;
    }
    public String addStudentToCourse(int sid, int cid){
        Student s=searchStudents(sid);
        Course c=searchCourse(cid);
        if(s!=null) {
            List<Student> student = c.getStudents();
            student.add(s);
            couRepo.save(c);
            System.out.println("Added");
            return "student added";
        }
        return "student not rigistered" ;
    }
    public void deletingStudent(int id){
        stuRepo.deleteById(id);
    }
    public void deletingCourse(int id){
        couRepo.deleteById(id);
    }
    public void deleteCourseOfStudent(int sid,int cid){
        Student student=stuRepo.findById(sid).orElse(null);
        if(student.getCourses()!=null){
            student.getCourses().removeIf(course->course.getCourseId()==cid);
            System.out.println("deletedddd");
            stuRepo.save(student);
            }
    }

    public Student updateStudent(Student student){
        return stuRepo.save(student);
    }
    public Course updateCourse(Course course){
        return couRepo.save(course);
    }


}
