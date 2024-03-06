package com.example.BookStoreWithMappings.service;

import com.example.BookStoreWithMappings.entity.Book;
import com.example.BookStoreWithMappings.entity.Cart;
import com.example.BookStoreWithMappings.entity.Orders;
import com.example.BookStoreWithMappings.entity.User;
import com.example.BookStoreWithMappings.models.OrderModel;
import com.example.BookStoreWithMappings.repository.BookRepo;
import com.example.BookStoreWithMappings.repository.CartRepo;
import com.example.BookStoreWithMappings.repository.OrderRepo;
import com.example.BookStoreWithMappings.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private UserRepo userRepo;
    public List<Book> orders(int userId, int bookId, int quantity,int  cartId){
        Book book=bookRepo.findById(bookId).orElse(null);
        if(book.getBookQuantity()<quantity){
            return null;
        }
        Cart userCart=cartRepo.findById(cartId).orElse(null);
        Orders orders=userCart.getOrders();
       if(orders==null){
           orders=new Orders();
           orders.setCart(userCart);

       }
       book.setBookQuantity(book.getBookQuantity()-quantity);
       List<Book> bookList=orders.getBookList();
       bookList.add(book);
       orderRepo.save(orders);

       List<Book> books=userCart.getBooks();
       books.removeIf(b->b.getBookId()==bookId);
       cartRepo.save(userCart);

       return bookList;

    }
}
