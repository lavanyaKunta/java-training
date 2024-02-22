package com.example.EmployeeMappings.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jpa_laptops")
public class Laptop {
    @Id
    @Column(name="Id")
    private int laptopId;
    @Column(name="Brand")
    private String brand;
    @Column(name="Price")
    private int price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
