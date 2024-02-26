package com.example.ManyToMany.model;
import com.example.ManyToMany.entity.Course;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class StudentModel {
    private int studentId;
    private String studentName;
    private int studentAge;
    private List<Course> courses=new ArrayList<>();

}
