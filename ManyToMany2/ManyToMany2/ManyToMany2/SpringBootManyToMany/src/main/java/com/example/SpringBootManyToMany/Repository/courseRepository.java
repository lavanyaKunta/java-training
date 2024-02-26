package com.example.SpringBootManyToMany.Repository;

import com.example.SpringBootManyToMany.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Courses,Integer>{

}
