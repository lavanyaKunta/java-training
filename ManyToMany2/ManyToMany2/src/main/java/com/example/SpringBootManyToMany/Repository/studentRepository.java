package com.example.SpringBootManyToMany.Repository;

import com.example.SpringBootManyToMany.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {
}
