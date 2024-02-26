package com.example.OneToMany;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.OneToMany.repo.studentRepo;
import com.example.OneToMany.repo.courseRepo;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OneToManyApplication {
	private final studentRepo stuRepo;

    public OneToManyApplication(studentRepo stuRepo) {
        this.stuRepo = stuRepo;
    }

    public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
//		ConfigurableApplicationContext context=SpringApplication.run(OneToManyApplication.class, args);
//		studentRepo stuRepo = context.getBean(studentRepo.class);

//		Student student=new Student();
//		student.setStudentId(1);
//		student.setStudentName("lavanya");
//		student.setAge(15);
//
//		Course c1=new Course();
//		c1.setCourseId(11);
//		c1.setCourseName("java");
//		c1.setCourseGuid("revi");
//		c1.setStudent(student);
//
//		Course c2=new Course();
//		c2.setCourseId(22);
//		c2.setCourseName("react");
//		c2.setCourseGuid("jone");
//		c2.setStudent(student);
//
//		List<Course> courseList=new ArrayList<>();
//		courseList.add(c1);
//		courseList.add(c2);
//
//		student.setCourseList(courseList);
//
//		Student save= stuRepo.save(student);


	}

}
