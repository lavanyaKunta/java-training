package com.example.SpringBootManyToMany;

import com.example.SpringBootManyToMany.Entity.Courses;
import com.example.SpringBootManyToMany.Entity.Student;
import com.example.SpringBootManyToMany.Repository.studentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootManyToManyApplication {
//	private  final studentRepository repository;
//
//    public SpringBootManyToManyApplication(studentRepository repository) {
//        this.repository = repository;
//    }

	public static void main(String[] args) {
		//ConfigurableApplicationContext context=
				SpringApplication.run(SpringBootManyToManyApplication.class, args);
		//studentRepository repository=context.getBean(studentRepository.class);

//		Student s1=new Student();
//		s1.setId(97);
//		s1.setName("Jamuna Enugula");
//		s1.setAge(21);
//
//		Student s2=new Student();
//		s2.setId(98);
//		s2.setName("Jamuna S");
//		s2.setAge(22);
//
//
//		Courses c1=new Courses();
//		c1.setCourseId(42);
//		c1.setCourseName("Java");
//		c1.setCourseGuide("jj");
//
//		Courses c2=new Courses();
//		c2.setCourseId(48);
//		c2.setCourseName("React");
//		c2.setCourseGuide("nn");
//
//		List<Courses> student1Course=s1.getCoursesList();
//		student1Course.add(c1);
//		student1Course.add(c2);
//		//s2.setCoursesList(student1Course);
//
//		List<Courses> student2Course=s2.getCoursesList();
//		student2Course.add(c1);
//		student2Course.add(c2);
//		repository.save(s1);
		//s2.setCoursesList(student2Course);
//		repository.save(s2);
	//	student1Course.setCoursesList(c);
	}

}
