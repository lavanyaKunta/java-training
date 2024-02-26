package com.example.OneToMany.service;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.entity.Student;
import com.example.OneToMany.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {
    @Autowired
    studentRepo stuRepo;
    public Student addStudent(Student student){
        Optional<Student> stu=stuRepo.findById(student.getStudentId());
        if(stu.isEmpty()) {
            return stuRepo.save(student);

        }
        return null;
    }
    public List<Student> getAllStudents(){
       return stuRepo.findAll();

    }
    public boolean addCourse(Course course){
        Student s=stuRepo.findById(course.getStudent().getStudentId()).orElse(null);
        if(s!=null){
            List<Course> couList=s.getCourseList();
            couList.add(course);
            s.setCourseList(couList);
            stuRepo.save(s);
            return true;
        }
        return false;

    }
    public List<Course> studentCourses(int id){
        Student stu=stuRepo.findById(id).orElse(null);
        return stu.getCourseList();
    }
    public Student deletingStudent(int id){
        Student stu=stuRepo.findById(id).orElse(null);
        if(stu==null)
            return null;
        stuRepo.deleteById(id);
        return stu;
    }
    public Student searchStudents(int id) {
        Optional<Student> stu=stuRepo.findById(id);
        return stu.orElse(null);
    }
    public Student updateStudent(Student student){
        return stuRepo.save(student);
    }
}
