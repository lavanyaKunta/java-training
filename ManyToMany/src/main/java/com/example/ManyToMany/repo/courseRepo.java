package com.example.ManyToMany.repo;

import com.example.ManyToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepo extends JpaRepository<Course,Integer> {
}
