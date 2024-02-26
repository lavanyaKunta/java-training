package com.example.SpringBootManyToMany.Models;

import com.example.SpringBootManyToMany.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseModel {
    private int courseId;
    private String courseName;
    private String courseGuide;
    private List<Student> studentList=new ArrayList<>();

    public CourseModel() {
    }

    public CourseModel(int courseId, String courseName, String courseGuide, List<Student> studentList) {
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

    @Override
    public String toString() {
        return "CourseModel{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseGuide='" + courseGuide + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
