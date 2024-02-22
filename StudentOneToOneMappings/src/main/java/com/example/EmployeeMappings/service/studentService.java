package com.example.EmployeeMappings.service;

import com.example.EmployeeMappings.entity.Laptop;
import com.example.EmployeeMappings.entity.Student;
import com.example.EmployeeMappings.repo.laptopRepo;
import com.example.EmployeeMappings.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class studentService {
    @Autowired
    private studentRepo stuRepo;
    @Autowired
    private laptopRepo lapRepo;

    public studentService() {
    }
    public Student addStudent(Student student){
        Optional<Student> stu=stuRepo.findById(student.getStudentId());
        if(stu.isEmpty())
            return stuRepo.save(student);
        return null;
    }
    public Laptop addLaptop(Laptop laptop){
        Optional<Laptop> lap=lapRepo.findById(laptop.getLaptopId());
        if(lap.isEmpty()){
            ArrayList<Laptop> laptops=(ArrayList<Laptop>) lapRepo.findAll();
            Laptop lapi= laptops.stream().filter(lapObj -> lapObj.getStudent().getStudentId()==laptop.getStudent().getStudentId()).findFirst().orElse(null);
            if(lapi == null){
                return lapRepo.save(laptop);
            } else {
                return null;
            }
        }
        return null;
    }

    public List<Student> getAllStudents(){
        return stuRepo.findAll();
    }
    public List<Laptop> getAllLaptops(){
        return lapRepo.findAll();
    }

    public List<Laptop>getStudentLaptop(){
        List<Laptop> laptop=lapRepo.findAll();
        List<Laptop> lap=laptop.stream().filter(l->l.getStudent()!=null).collect(Collectors.toList());
        return lap;
    }
    public Student searchStudents(int id) {
        Optional<Student> stu=stuRepo.findById(id);
        return stu.orElse(null);
    }
    public Student deletingStudent(int id){
        Student stu=stuRepo.findById(id).orElse(null);
        if(stu==null){
            return null;
        }
        else {
                List<Laptop> laptop=lapRepo.findAll();
                Laptop lap=laptop.stream().filter(l->l.getStudent()== stuRepo.getReferenceById(id)).findFirst().orElse(null);
                if(lap!=null){
                    lap.setStudent(null);
                    lapRepo.save(lap);
                }
                stuRepo.deleteById(id);

            }
        return stu;
    }

    public Student updateStudent(Student stu){
        return stuRepo.save(stu);
    }
}
