package com.example.SpringBootManyToMany.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {
    @Id
    private int courseId;
    private String courseName;
    private String courseGuide;

    @ManyToMany(mappedBy = "coursesList",fetch = FetchType.EAGER)
    private List<Student> studentList=new ArrayList<>();

    public Courses() {
    }

    public Courses(int courseId, String courseName, String courseGuide, List<Student> studentList) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseGuide = courseGuide;
        this.studentList = studentList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseGuide() {
        return courseGuide;
    }

    public void setCourseGuide(String courseGuide) {
        this.courseGuide = courseGuide;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
