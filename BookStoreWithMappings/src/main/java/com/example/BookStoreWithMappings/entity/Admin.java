package com.example.BookStoreWithMappings.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Table(name="admin")
public class Admin {
    @Id
    @Column(name="adminId")
    private int adminId;

    @Column(name="password")
    private String adminPassword;
    @OneToMany(mappedBy = "adminId",cascade = CascadeType.ALL)
    private List<Book> bookList=new ArrayList<>();

    public Admin() {
    }

    public Admin(int adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminPassword='" + adminPassword + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
