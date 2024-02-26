package com.example.ManyToMany.model;

import com.example.ManyToMany.entity.Course;
import com.example.ManyToMany.entity.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CourseModel {
    private int courseId;
    private String courseName;
    private String courseGuid;
    private List<Student> students=new ArrayList<>();
}
