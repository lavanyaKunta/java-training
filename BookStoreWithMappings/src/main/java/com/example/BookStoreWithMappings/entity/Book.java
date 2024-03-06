package com.example.BookStoreWithMappings.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Table(name="book")
public class Book {
    @Id
    @Column(name="bookId")
    private Integer bookId;
    @Column(name="bookName")
    private String bookName;
    @Column(name="bookAuthor")
    private String bookAuthor;
    @Column(name="bookCategory")
    private String bookCategory;
    @Column(name="bookPrice")
    private int bookPrice;
    @Column(name="bookQuantity")
    private int bookQuantity;
    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin adminId;

    @Column(name="userId")
    @ManyToMany(mappedBy ="bookList",fetch= FetchType.EAGER )
    private List<User> userList=new ArrayList<>();

    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER)
    private List<Cart> carts=new ArrayList<>();

    @ManyToMany(mappedBy = "bookList")
    private List<Orders> ordersList=new ArrayList<>();


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Admin getAdmin() {
        return adminId;
    }

    public void setAdmin(Admin adminId) {
        this.adminId = adminId;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

//    public List<Cart> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }
}
