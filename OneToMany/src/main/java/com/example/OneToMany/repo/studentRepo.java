package com.example.OneToMany.repo;

import com.example.OneToMany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<Student, Integer> {
}
