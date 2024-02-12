package Admin;

import BookStore.Book;
import DETAILS.Details;

import java.util.ArrayList;
import java.util.Scanner;

import static DETAILS.Details.books;

public class AdminService {
    public void login(){
        ArrayList<Book> books = Details.books;
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER ADMIN USERNAME : ");
        String username=sc.next();
        //ArrayList<Admin> admins = Details.admins;
        if(username.equals(username)){
            System.out.print("ENTER PASSWORD : ");
            String password=sc.next();
            if(password.equals(password)){
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
                            viewAllBooks();
                            break;
                        case 2:
                            System.out.println("ENTER BOOKNAME: ");
                            String title = sc.next();
                            System.out.println("ENTER QUANTITY: ");
                            int quantity = sc.nextInt();
                            Book exist =BookExist(title, quantity);
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
                                        Book book_name = UpdateBookName(oldBookName,newBookName);
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
                                        Book book_price = UpdatePrice(bookName, newPrice);
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
                                                IncreaseQuantity(BookName,Quantity);
                                                System.out.println("QUNTITY INCRESED SUCCESFULLY!");
                                                break;
                                            case 2:
                                                DecreaseQuantity(BookName,Quantity);
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
                            Book book = deleteBook(bookname);
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




    public void viewAllBooks(){
            books.stream().forEach(book-> System.out.println( "BookName :"+book.getTitle()+"\tAuthor: "+book.getAuthor()+"\tPrice: "+book.getPrice()+"\tCategory: "+book.getCategory()+"\tQuantity: "+book.getQuantity()));
        }
        public Book BookExist(String bookname,int quantity){
            return books.stream().filter(book->bookname.equals(book.getTitle())).findFirst().map(book->{
                int newQuantity=book.getQuantity()+quantity;
                book.setQuantity(newQuantity);
                return book;
            }).orElse(null);
        }
        public Book deleteBook(String bookname){
            return books.stream().filter(book->bookname.equalsIgnoreCase(book.getTitle())).findFirst().map(book->{
                book.setQuantity(0);
                return book;
            }).orElse(null);
        }
        public Book UpdatePrice(String bookName,double newprice){
            return books.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(bookName))
                    .findFirst()
                    .map(book -> {
                        book.setPrice(newprice);
                        return book;
                    })
                    .orElse(null);
        }
        public Book UpdateBookName(String OldBookName,String newBookName){
            return books.stream().filter(book->OldBookName.equalsIgnoreCase(book.getTitle())).findFirst().
                    map(book->{
                        book.setTitle(newBookName);
                        return book;
                    }).orElse(null);
        }
        public Book IncreaseQuantity(String BookName,int quantity){
            return books.stream().filter(book->BookName.equalsIgnoreCase(book.getTitle())).findFirst().
                    map(book->{
                        int newQuantity=book.getQuantity()+quantity;
                        book.setQuantity(newQuantity);
                        return book;
                    }).orElse(null);
        }
        public Book DecreaseQuantity(String BookName,int quantity){
            return books.stream().filter(book->BookName.equalsIgnoreCase(book.getTitle())).findFirst().
                    map(book->{
                        int newQuantity=book.getQuantity()-quantity;
                        book.setQuantity(newQuantity);
                        return book;
                    }).orElse(null);
        }




}
