package com.example.OneToMany.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="student")
public class Student {
    @Id
    @Column(name="StudentId")
    private int studentId;
    @Column(name="StudentName")
    private String studentName;
    @Column(name="Age")
    private int age;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Course> courseList=new ArrayList<>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
