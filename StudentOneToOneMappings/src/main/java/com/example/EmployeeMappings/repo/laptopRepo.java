package com.example.EmployeeMappings.repo;

import com.example.EmployeeMappings.entity.Laptop;
import com.example.EmployeeMappings.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface laptopRepo extends JpaRepository<Laptop, Integer> {
}
