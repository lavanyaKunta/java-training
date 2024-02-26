package com.example.OneToMany.repo;

import com.example.OneToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepo extends JpaRepository<Course, Integer> {
}
