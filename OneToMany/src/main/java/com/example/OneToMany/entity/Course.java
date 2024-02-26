package com.example.OneToMany.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @Column(name="CourseId")
    private int courseId;
    @Column(name="CourseName")
    private String courseName;
    @Column(name="GuidName")
    private String courseGuid;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

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

    public String getCourseGuid() {
        return courseGuid;
    }

    public void setCourseGuid(String courseGuid) {
        this.courseGuid = courseGuid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
