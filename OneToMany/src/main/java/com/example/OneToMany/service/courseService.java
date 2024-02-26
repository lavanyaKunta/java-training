package com.example.OneToMany.service;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.entity.Student;
import com.example.OneToMany.repo.courseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class courseService {
    @Autowired
    courseRepo couRepo;
    public Course addCourse(Course course){
       Optional<Course> cou=couRepo.findById(course.getCourseId());
       if(cou.isEmpty()){
           return couRepo.save(course);
       }
      return null;
    }
    public Course deleteingCourse(int courseId) {
        Course cou = couRepo.findById(courseId).orElse(null);
        couRepo.deleteById(courseId);
        return cou;

    }
    public Course updateCourse(Course course){
        return couRepo.save(course);
    }


}
