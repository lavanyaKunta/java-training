package Admin;

import BookStore.*;
import DETAILS.Details;

import java.util.*;

public class Admin {
    private String username;
    private String password;
    public Admin(){
        username="lavanya";
        password="123";
    }
//    public Admin(String username,String password){
//        this.a_username=username;
//        this.a_password=password;
//    }
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }


    Book bookstore;


    public void login(){
        AdminService service = new AdminService();
        ArrayList<Book> books = Details.books;
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER ADMIN USERNAME : ");
        String username=sc.next();
        //ArrayList<Admin> admins = Details.admins;
        if(this.username.equals(username)){
            System.out.print("ENTER PASSWORD : ");
            String password=sc.next();
            if(this.password.equals(password)){
                System.out.println("LOGIN SUCCESSFUL");
                boolean logout=false;
                do{
                    System.out.println();
                    System.out.println("1.VIEW ALL BOOKS DETAILS  \n2.ADD BOOK  \n3.UPDATE BOOK  \n4.DELETE BOOK \n5.LOGOUT\n");
                    System.out.print("ENTER YOUR CHOICE : ");
                    int adminChoice = sc.nextInt();
                    System.out.println();
                    switch (adminChoice){
                        case 1:
                            service.viewAllBooks();
                            break;
                        case 2:
                            System.out.println("ENTER BOOKNAME: ");
                            String title = sc.next();
                            System.out.println("ENTER QUANTITY: ");
                            int quantity = sc.nextInt();
                            Book exist = service.BookExist(title, quantity);
                            System.out.println(exist);
                            if (exist== null) {
                                System.out.println("ENTER AUTHOR_NAME: ");
                                String author = sc.next();
                                System.out.println("ENTER PRICE: ");
                                int price = sc.nextInt();
                                System.out.println("ENTER CATEGORY: ");
                                String category = sc.next();
                                books.add(new Book(title, author, price, quantity, category));
                                System.out.println("BOOK ADDED SUCCESFULLY!");
                            }
                            else {
                                System.out.println("BOOK ALREADY EXIST! QUANTITY ADDED SUCCESFULLY!");
                            }
                            break;

                        case 3:
                            boolean exit=false;
                            do{
                            System.out.println("1.UPDATE BOOKNAME\n2.UPDATE PRICE\n3.UPDATE QUANTITY\n4.EXIT FROM UPDATE\n");
                            System.out.print("ENTER YOUR CHOICE : ");
                            int Choice = sc.nextInt();
                            System.out.println();
                            switch(Choice){
                                case 1:
                                    System.out.println("ENTER OLD BOOKNAME: ");
                                    String oldBookName = sc.next();
                                    System.out.println("ENTER NEW BOOKNAME: ");
                                    String newBookName = sc.next();
                                    Book book_name = service.UpdateBookName(oldBookName,newBookName);
                                    if (book_name != null)
                                        System.out.println("BOOK NAME UPDATE SUCCESFULLY!");
                                    else {
                                        System.out.println("BOOk NOT FOUND TO UPDATE");
                                    }
                                       break;
                                case 2:
                                    System.out.println("ENTER BOOKNAME: ");
                                    String bookName = sc.next();
                                    System.out.println("ENTER OLD PRICE: ");
                                    double newPrice = sc.nextDouble();
                                    Book book_price = service.UpdatePrice(bookName, newPrice);
                                    if (book_price != null)
                                        System.out.println("BOOK PRICE UPDATE SUCCESFULLY!");
                                    else {
                                        System.out.println("BOOk NOT FOUND TO UPDATE");
                                    }
                                        break;
                                case 3:
                                    System.out.println("1.INCREASE\n2.DECREASE\n");
                                    System.out.print("ENTER YOUR CHOICE : ");
                                    int choice = sc.nextInt();
                                    System.out.println("ENTER BOOKNAME: ");
                                    String BookName = sc.next();
                                    System.out.println("ENTER QUANTITY : ");
                                    int Quantity=sc.nextInt();
                                    switch(choice){
                                        case 1:
                                            service.IncreaseQuantity(BookName,Quantity);
                                            System.out.println("QUNTITY INCRESED SUCCESFULLY!");
                                            break;
                                        case 2:
                                            service.DecreaseQuantity(BookName,Quantity);
                                            System.out.println("QUNTITY DECRESED SUCCESFULLY!");
                                            break;
                                    }
                                case 4:
                                    exit=true;
                                    break;
                                default:
                                    System.out.println("INVALID INPUT");
                                }
                            }while(!exit);

                            break;
                        case 4:

                            System.out.println("ENTER BOOKNAME: ");
                            String bookname = sc.next();
                            Book book = service.deleteBook(bookname);
                            if (book!= null)
                                System.out.println("BOOK DELETED SUCCESFULLY!");
                            else {
                                System.out.println("BOOK NOT FOUND TO DELETE");
                            }
                            break;
                        case 5:
                            logout=true;
                            break;
                        default:
                            System.out.println("INVALID INPUT");
                    }
                }while(!logout);

            } else {
                System.out.println("INCORRECT PASSWORD");
            }
        } else {
            System.out.println("USERNAME DOESN'T MATCH");
        }
    }
}
