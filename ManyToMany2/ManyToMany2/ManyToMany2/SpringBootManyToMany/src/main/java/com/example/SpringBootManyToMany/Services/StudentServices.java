package com.example.SpringBootManyToMany.Services;

import com.example.SpringBootManyToMany.Entity.Courses;
import com.example.SpringBootManyToMany.Entity.Student;
import com.example.SpringBootManyToMany.Models.CourseModel;
import com.example.SpringBootManyToMany.Models.StudentModel;
import com.example.SpringBootManyToMany.Repository.studentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class
StudentServices {

    @Autowired
    private studentRepository repo;

    public StudentModel saveStudent(StudentModel studentModel) {
        Student s = repo.findById(studentModel.getId()).orElse(null);
        if (s != null) {
            return null;
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentModel, student);
        repo.save(student);
        return studentModel;
    }

    public List<StudentModel> getAllStudents() {
        List<Student> students=repo.findAll();
        List<StudentModel> studentList=new ArrayList<>();
        students.forEach(s->{
            StudentModel studentModel=new StudentModel();
            BeanUtils.copyProperties(s,studentModel);
            studentList.add(studentModel);
        });
        return studentList;
    }

    public List<CourseModel> getAllCourses(int id) {
        Student s = repo.findById(id).orElse(null);
        List<CourseModel> courseModelList=new ArrayList<>();

        if (s != null) {
            List<Courses> coursesList = s.getCoursesList();
            coursesList.forEach(c->{
                CourseModel courses=new CourseModel();
                BeanUtils.copyProperties(c,courses);
                courseModelList.add(courses);
            });
        }
        return courseModelList;
    }

    public String addCourse(int id, CourseModel course) {
        Student s=repo.findById(id).orElse(null);
        if(s==null){
            return "student Id is not Registerd";
        }
        List<Courses> courseList=s.getCoursesList();
        Courses c1=new Courses();
        BeanUtils.copyProperties(course,c1);
        courseList.add(c1);
        repo.save(s);
        return "Added Successfully";
    }

    public StudentModel searchStudent(int id) {
        Student s1=repo.findById(id).orElse(null);
        StudentModel s=new StudentModel();
        BeanUtils.copyProperties(s1,s);
        return s;
    }

    public String deleteStudent(int id) {
         repo.deleteById(id);
        return "deleted";
    }

    public String deleteCourse(int id) {
        List<Student> studentList=repo.findAll();
        studentList.forEach(s-> System.out.println(s));
        studentList.forEach(student->{
            if(student.getCoursesList()!=null){
                student.getCoursesList().removeIf(course -> course.getCourseId()==(id));
                repo.save(student);

            }
        });

        return "removed";
    }

    public void deleteCourseOfStudent(int id, int cid) {
        Student student=repo.findById(id).orElse(null);
        if(student.getCoursesList()!=null){
            student.getCoursesList().removeIf(course -> course.getCourseId()==(cid));
            repo.save(student);
            System.out.println("course Deleted");
        }
        System.out.println("course not deleted");
    }
}
