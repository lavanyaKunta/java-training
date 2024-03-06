package com.example.BookStoreWithMappings.service;

import com.example.BookStoreWithMappings.entity.Admin;
import com.example.BookStoreWithMappings.entity.Book;
import com.example.BookStoreWithMappings.entity.User;
import com.example.BookStoreWithMappings.models.BookModel;
import com.example.BookStoreWithMappings.repository.AdminRepo;
import com.example.BookStoreWithMappings.repository.BookRepo;
import com.example.BookStoreWithMappings.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    public BookModel addBook(BookModel bookModel, int adminId){
        Admin admin=adminRepo.getReferenceById(adminId);
        Book b=bookRepo.findById(bookModel.getBookId()).orElse(null);
        if(b!=null){
            return null;
        }
        Book book=new Book();
        BeanUtils.copyProperties(bookModel,book);
        book.setAdmin(admin);
        bookRepo.save(book);
        return bookModel;
    }
    public List<BookModel> getAdminBooks(int adminId){
        Admin admin=adminRepo.findById(adminId).orElse(null);
        List<BookModel>bookModelList=new ArrayList<>();
        if(admin!=null){
            List<Book>bookList=admin.getBookList();
            bookList.forEach(b->{
                BookModel book=new BookModel();
                BeanUtils.copyProperties(b,book);
                bookModelList.add(book);
            });
        }
        return bookModelList;
    }
    public Book deletingBook(int bookId){
        Book book=bookRepo.findById(bookId).orElse(null);
        if(book!=null) {
            bookRepo.deleteById(bookId);
            return book;
        }
        return null;
    }
    public Book increaseQuantity(int bookId,int quantity){
        Book book=bookRepo.findById(bookId).orElse(null);
        if(book!=null){
            int count=book.getBookQuantity();
            count=count+quantity;
            book.setBookQuantity(count);
            bookRepo.save(book);
            return book;
        }
        return null;
    }
    public Book decreaseQuantity(int bookId,int quantity){
        Book book=bookRepo.findById(bookId).orElse(null);
        int count=book.getBookQuantity();
        if(quantity<=count){
            count=count-quantity;
            book.setBookQuantity(count);
            bookRepo.save(book);
            return book;
        }
        return null;
    }

    public Book updateBook(Book book){
    return bookRepo.save(book);
    }
    public List<BookModel> getAllBooks(){
        List<BookModel>bookModelList=new ArrayList<>();
        List<Book>bookList=bookRepo.findAll();
        bookList.forEach(b->{
            BookModel book=new BookModel();
            BeanUtils.copyProperties(b,book);
            bookModelList.add(book);
        });
        return bookModelList;
    }

    public Book searchBook(int bookId) {
        return bookRepo.findById(bookId).orElse(null);
        }


}
