package DETAILS;

import java.util.ArrayList;
import User.User;
import Admin.*;
import BookStore.*;
public class Details {
    public static ArrayList<Book> books= new ArrayList<>();
    public static ArrayList<User> users=new ArrayList<>();
    public static ArrayList<Admin> admins=new ArrayList<>();
    public Details(){

        Book b1=new Book("CleanCode", "Robert", 250, 3, "software");
        Book b2=new Book("Inclusive_Design_Patterns", "Gene Kim", 300, 2, "software");
        Book b3=new Book("The_Discovery_of_India", "Jawaharlal Nehru", 100, 1, "history");
        Book b4=new Book("You_Are_The_BestWife", "Ajay k Pandey", 120, 2, "story");
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        User u1=new User("lavanya", "1224",1234);
        User u2=new User("jamuna", "123",4321);
        users.add(u1);
        users.add(u2);

        Admin a1=new Admin("lavanya", "123");
        Admin a2=new Admin("jamuna","1234");
        admins.add(a1);
        admins.add(a2);


    }

    public void addbook(Book book)
    {
        books.add(book);
    }
//    public void adduser(User user){
//
//        users.add(user);
//    }
//    public void addadmin(Admin admin)
//    {
//        admins.add(admin);
//    }

}

