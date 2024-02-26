package com.example.SpringBootManyToMany.Models;

import com.example.SpringBootManyToMany.Entity.Courses;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentModel {
    private int id;
    private String name;
    private int Age;
    private List<Courses> coursesList=new ArrayList<>();

    public StudentModel() {
    }

    public StudentModel(int id, String name, int age, List<Courses> coursesList) {
        this.id = id;
        this.name = name;
        Age = age;
        this.coursesList = coursesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Age=" + Age +
                ", coursesList=" + coursesList +
                '}';
    }
}
