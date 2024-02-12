package User;

import BookStore.Book;
import DETAILS.Details;

import java.util.ArrayList;
import java.util.Scanner;

import static DETAILS.Details.books;
import static DETAILS.Details.users;
public class UserService {
    Book bookstore;

    public void userRegister() {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username=sc.next();
        ArrayList<User> users= Details.users;
        if(!users.isEmpty()){
            boolean userNameExists= users.stream().anyMatch(obj-> obj.getUsername().equals(username));
            if(userNameExists){
                System.out.println("USERNAME ALREADY EXISTS!!!");
            } else {
                System.out.print("PASSWORD : ");
                String password=sc.next();
                System.out.println("ENTER CREDIT_CARD_NUMBER");
                int creditNumber=sc.nextInt();
                User obj=new User(username,password,creditNumber);
                users.add(obj);
            }
        } else {
            System.out.print("PASSWORD : ");
            String password=sc.next();
            System.out.println("ENTER CREDIT_CARD_NUMBER");
            int creditNumber=sc.nextInt();
            User obj=new User(username,password,creditNumber);
            users.add(obj);
        }
    }

    public void userLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username = sc.next();
        ArrayList<User> users = Details.users;
        if (!users.isEmpty()) {
            boolean userNameExists = users.stream().anyMatch(obj -> obj.getUsername().equals(username));
            if (userNameExists) {
                System.out.print("PASSWORD : ");
                String password = sc.next();
                User CurrentUser = users.stream()
                        .filter(obj -> obj.getUsername().equals(username) && obj.getPassword().equals(password))
                        .findFirst()
                        .orElse(null);

                if (CurrentUser!= null) {
                    System.out.println("LOGIN SUCCESSFUL");
                    System.out.println("ENTER AMOUNT YOU  CURRENTLY HAVE IN YOUR ACCOUNT: ");
                    double amount = sc.nextDouble();


                    boolean logout=false;
                    do {
                        System.out.println("\n1.VIEW BOOKS CATEGORY VISE\n2.CHECK BOOK AVILABILITY\n3.VIEW BOOK DETAILS\n4.PLACE ORDER\n5.VIEW ALL BOOKS\n6.LOGOUT ");
                        System.out.print("ENTER CHOICE :  ");
                        int userChoice = sc.nextInt();
                        System.out.println();
                        switch (userChoice) {
                            case 1:
                                boolean category=false;
                                do {
                                    System.out.println("ChOOSE CATEGORY:\n1.software\t2.history\t3.english\t4.science\t5.story\t6.Exit");
                                    Integer c = sc.nextInt();
                                    switch (c) {
                                        case 1:
                                            ArrayList<String> software = BookCategory("software");
                                            software.stream().forEach(i -> System.out.println(i));
                                            if (software.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;

                                        case 2:
                                            ArrayList<String> history = BookCategory("history");
                                            history.stream().forEach(i -> System.out.println(i));
                                            if (history.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 3:
                                            ArrayList<String> english = BookCategory("english");
                                            english.stream().forEach(i -> System.out.println(i));
                                            if (english.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 4:
                                            ArrayList<String> science = BookCategory("science");
                                            science.stream().forEach(i -> System.out.println(i));
                                            if (science.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 5:
                                            ArrayList<String> story = BookCategory("story");
                                            story.stream().forEach(i -> System.out.println(i));
                                            if (story.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 6:
                                            category = true;
                                            System.out.println("YOU ARE EXITED FROM CATEGORY VISE SEARCH..");
                                            break;
                                        default:
                                            System.out.println("INVALID CHOICE");

                                    }
                                }while (!category);
                                break;
                            case 2:
                                System.out.println("ENTER BOOKNAME");
                                String bookName = sc.next();

                                bookstore=BookAvilability(bookName);
                                if (bookstore != null)
                                    System.out.println("book is avilable");
                                else {
                                    System.out.println("book not avilable");
                                }
                                break;
                            case 3:
                                System.out.println("ENTER BOOKNAME");
                                String d_bookName = sc.next();
                                bookstore=BookDeatails(d_bookName);
                                if (bookstore!= null) {
                                    System.out.println("bookname :" + bookstore.getTitle() + "\nauthor: " + bookstore.getAuthor() + "\nprice: " + bookstore.getPrice() + "\nquantity: " + bookstore.getQuantity());
                                } else {
                                    System.out.println("BOOK NOT FOUND");
                                }

                                break;


                            case 4:
                                System.out.print("ENTER BOOKNAME: ");
                                String BookName = sc.next();
                                bookstore=checkBook(BookName);
                                if (bookstore != null) {
                                    System.out.println("ENTER QUANTITY : ");
                                    int quantity= sc.nextInt();
                                    System.out.println("ENTER CREDIT CARD NUMBER : ");
                                    int creditCardNumber= sc.nextInt();
                                    double k = placeOrder(BookName, quantity);
                                    if (k != -1) {
                                        double Amount = checkBalance(username, password,creditCardNumber, amount, k * quantity);
                                        if (Amount != -1) {
                                            amount = Amount;
                                            System.out.println("ORDER PLACED SUCCESSFULLY!!!");
                                        } else {
                                            System.out.println("INSUFFICIENT AMOUNT!");
                                        }
                                    } else {
                                        System.out.println("OUT OF STACK:(");
                                    }
                                } else {
                                    System.out.println("BOOK NOT FOUND!");
                                }
                                break;


                            case 5:
                                ViewAllBooks();
                                break;
                            case 6:
                                logout = true;
                                System.out.println("LOGGED OUT SUCCESSFULLY");
                                break;
                            default:
                                System.out.println("INVALID CHOICE");
                        }
                    } while (!logout);
                } else {
                    System.out.println("INCORRECT PASSWORD");
                }
            } else {
                System.out.println("USERNAME DOESN'T EXIST");
            }
        } else {
            System.out.println("USERNAME DOESN'T EXIST");
        }
    }



    public ArrayList<String> BookCategory(String category){
        ArrayList<String> bookList=new ArrayList<>();
        books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .map(Book::getTitle)
                .forEach(bookList::add);

        return bookList;
    }
    public Book BookAvilability(String bookname){
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(bookname) && book.getQuantity() > 0)
                .findFirst()
                .orElse(null);
    }
    public Book BookDeatails(String bookname){
        return books.stream().filter(book->book.getTitle().equalsIgnoreCase(bookname)).findFirst().orElse(null);
    }

    public Book checkBook(String bookname){
        return books.stream().filter(book-> book.getTitle().equalsIgnoreCase(bookname)).filter(book->book.getQuantity()>0).findFirst().orElse(null);
    }

    public double placeOrder(String bookname,int quantity){
        Book found=books.stream().filter(book->book.getTitle().equalsIgnoreCase(bookname) && book.getQuantity()>=quantity)
                .findFirst().orElse(null);
        if(found!=null){
            int  remainBooks=found.getQuantity()-quantity;
            found.setQuantity(remainBooks);
            return found.getPrice();
        }
        else{
            return -1;
        }


    }public double checkBalance(String username,String password,int creditCardNumber,double amount,double price){
        User found=users.stream().filter(user->user.getUsername().equals(username) && user.getPassword().equals(password) && user.getCreditCardNumber()==creditCardNumber)
                .findFirst().orElse(null);
        if(found!=null){
            found.setBalance(amount);
            if (amount >= price) {
                double newBalance = found.getBalance() - price;
                found.setBalance(newBalance);
                System.out.println(newBalance);
                return newBalance;
            }
        }
        return -1;
    }


    public void ViewAllBooks(){
        books.stream().forEach(book-> System.out.println( "BookName :"+book.getTitle()+"\tAuthor: "+book.getAuthor()+"\tPrice: "+book.getPrice()+"\tCategory: "+book.getCategory()+"\tQuantity: "+book.getQuantity()));
    }

}
