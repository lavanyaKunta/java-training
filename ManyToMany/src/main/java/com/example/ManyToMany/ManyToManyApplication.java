package com.example.ManyToMany;

import com.example.ManyToMany.entity.Course;
import com.example.ManyToMany.entity.Student;
import com.example.ManyToMany.repo.courseRepo;
import com.example.ManyToMany.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ManyToManyApplication {
//	private final studentRepo stuRepo;
//	private final courseRepo couRepo;
//
//	public ManyToManyApplication(studentRepo stuRepo, courseRepo couRepo) {
//		this.stuRepo = stuRepo;
//        this.couRepo = couRepo;
//    }
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
//		ConfigurableApplicationContext context=SpringApplication.run(ManyToManyApplication.class, args);
//		studentRepo stuRepo = context.getBean(studentRepo.class);
//		courseRepo couRepo = context.getBean(courseRepo.class);

//		Student s1=new Student();
//		s1.setStudentId(1);
//		s1.setStudentName("lavanya");
//		s1.setStudentAge(20);
//
//
//		Student s2=new Student();
//		s2.setStudentId(2);
//		s2.setStudentName("jamuna");
//		s2.setStudentAge(22);
//
//		Course c1=new Course();
//		c1.setCourseId(111);
//		c1.setCourseName("java");
//		c1.setCourseGuid("jone");
//
//		Course c2=new Course();
//		c2.setCourseId(222);
//		c2.setCourseName("sql");
//		c2.setCourseGuid("revi");
//
//		List<Course> student1Courses=s1.getCourses();
//		student1Courses.add(c1);
//		student1Courses.add(c2);
//
//		List<Course> student2Courses=s2.getCourses();
//		student2Courses.add(c1);
//
//		stuRepo.save(s1);
//		stuRepo.save(s2);
//
//		Student student=stuRepo.findById(1).get();
//		System.out.println(student.getCourses().size());
//
//
//		Student student2=stuRepo.findById(2).get();
//		System.out.println(student2.getCourses().size());
//
//		Course course=couRepo.findById(111).get();
//		System.out.println(course.getStudents().size());

	}


}
