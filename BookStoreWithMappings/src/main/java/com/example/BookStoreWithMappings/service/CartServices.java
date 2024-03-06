package com.example.BookStoreWithMappings.service;

import com.example.BookStoreWithMappings.entity.Book;
import com.example.BookStoreWithMappings.entity.Cart;
import com.example.BookStoreWithMappings.entity.User;
import com.example.BookStoreWithMappings.models.BookModel;
import com.example.BookStoreWithMappings.models.CartModel;
import com.example.BookStoreWithMappings.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartServices {
    @Autowired
    private CartRepo cartRepo;

    public CartModel addToCart(Book book, User user) {
        List<Cart> cartList=cartRepo.findAll();

        AtomicInteger cartId = new AtomicInteger();
        Cart cart=new Cart();
        cartList.forEach(c ->{
            if(c.getUser().getUserId()== user.getUserId()){
                cartId.set(c.getCartId());
            }
        });
        if(cartId.get()!=0){
            cart=cartRepo.findById(cartId.get()).orElse(null);
        }

        cart.setUser(user);
        AtomicBoolean bookexist = new AtomicBoolean(false);
        List<Book> bookList=cart.getBooks();
        bookList.forEach(b->{
            if(b.getBookId()== book.getBookId()){
                bookexist.set(true);
            }
        });
        if(bookexist.get()){
            return null;
        }
        bookList.add(book);
        System.out.println(cart);
        cartRepo.save(cart);
        CartModel cartModel=new CartModel();
        cartModel.setCartId(cart.getCartId());
        cartModel.setBooks(cart.getBooks());
        cartModel.setUser(cart.getUser());
        return cartModel;
    }
    public List<Book> getAllBooks(int cartId){
        Cart cart=cartRepo.findById(cartId).orElse(null);
        if(cart!=null) {
            List<Book> bookList = cart.getBooks();
//            CartModel cartModel=new CartModel();
//            cartModel.setBooks(bookList);
//            List<Book> b=cartModel.getBooks();
            return bookList;
        }
        return null;
    }
}
