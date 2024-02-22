package com.example.EmployeeMappings.repo;

import com.example.EmployeeMappings.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<Student, Integer> {
}
