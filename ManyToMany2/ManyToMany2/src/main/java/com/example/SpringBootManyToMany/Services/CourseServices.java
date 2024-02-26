package com.example.SpringBootManyToMany.Services;

import com.example.SpringBootManyToMany.Entity.Courses;
import com.example.SpringBootManyToMany.Entity.Student;
import com.example.SpringBootManyToMany.Models.CourseModel;
import com.example.SpringBootManyToMany.Models.StudentModel;
import com.example.SpringBootManyToMany.Repository.courseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServices {
    @Autowired
    private courseRepository repo;
    public  CourseModel saveCourse(CourseModel courseModel) {
        Courses c=repo.findById(courseModel.getCourseId()).orElse(null);
        if(c!=null){
            return null;
        }
        Courses course=new Courses();
        BeanUtils.copyProperties(courseModel,course);
        repo.save(course);
        return courseModel;
    }

    public List<CourseModel> getAllCourses() {
        List<Courses> coursesList=repo.findAll();
        List<CourseModel> courseModelList=new ArrayList<>();
        coursesList.forEach(c->{
                CourseModel courses=new CourseModel();
                BeanUtils.copyProperties(c,courses);
                courseModelList.add(courses);
        });
        return courseModelList;
    }

    public List<StudentModel> getAllStudents(int id) {
        Courses c=repo.findById(id).orElse(null);
        List<StudentModel> studentList=new ArrayList<>();
        if(c!=null) {
            List<Student> students=c.getStudentList();
            students.forEach(s -> {
                StudentModel studentModel = new StudentModel();
                BeanUtils.copyProperties(s, studentModel);
                studentList.add(studentModel);
            });
        }
        return studentList;
    }

    public CourseModel searchCourse(int courseId) {
        Courses courses=repo.findById(courseId).orElse(null);
        if(courses==null){
            return null;
        }
        CourseModel courseModel=new CourseModel();
        BeanUtils.copyProperties(courses,courseModel);
        return courseModel;
    }

    public String addStudent(int cid, StudentModel student) {
        System.out.println(cid);
        Courses courses=repo.findById(cid).orElse(null);
        List<Student> studentList=courses.getStudentList();
        Student s=new Student();
        BeanUtils.copyProperties(student,s);
        studentList.add(s);
        repo.save(courses);
        return "added Successfully";

    }

    public String deleteCourse(int id) {
        Courses course=repo.findById(id).orElse(null);
        System.out.println(course);
        course.setStudentList(null);
        repo.save(course);
        repo.deleteById(id);
        return "deleted";
    }
}
