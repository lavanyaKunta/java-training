package User;

import BookStore.*;
import java.util.*;
import DETAILS.Details;
public class User
{
    private String username;
    private String password;
    private int creditCardNumber;
    private double balance;
    public User(){

    }
    public User(String username,String password,int creditCardNumber){
        this.username=username;
        this.password=password;
        this.creditCardNumber=creditCardNumber;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public int getCreditCardNumber() {

        return creditCardNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double bal) {

        balance=bal;
    }
    UserService service = new UserService();
    Book bookstore;
    public void userRegister() {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username=sc.next();
        ArrayList<User> users=Details.users;
        if(!users.isEmpty()){
            boolean userNameExists= users.stream().anyMatch(obj->obj.username.equals(username));
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
            boolean userNameExists = users.stream().anyMatch(obj -> obj.username.equals(username));
            if (userNameExists) {
                System.out.print("PASSWORD : ");
                String password = sc.next();
                User CurrentUser = users.stream()
                        .filter(obj -> obj.username.equals(username) && obj.password.equals(password))
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
                                            ArrayList<String> software = service.BookCategory("software");
                                            software.stream().forEach(i -> System.out.println(i));
                                            if (software.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;

                                        case 2:
                                            ArrayList<String> history = service.BookCategory("history");
                                            history.stream().forEach(i -> System.out.println(i));
                                            if (history.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 3:
                                            ArrayList<String> english = service.BookCategory("english");
                                            english.stream().forEach(i -> System.out.println(i));
                                            if (english.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 4:
                                            ArrayList<String> science = service.BookCategory("science");
                                            science.stream().forEach(i -> System.out.println(i));
                                            if (science.isEmpty()) {
                                                System.out.println("BOOKS NOT AVILABLE IN THIS CATEGORY");
                                            }
                                            break;
                                        case 5:
                                            ArrayList<String> story = service.BookCategory("story");
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

                                bookstore=service.BookAvilability(bookName);
                                if (bookstore != null)
                                    System.out.println("book is avilable");
                                else {
                                    System.out.println("book not avilable");
                                }
                                break;
                            case 3:
                                System.out.println("ENTER BOOKNAME");
                                String d_bookName = sc.next();
                                bookstore=service.BookDeatails(d_bookName);
                                if (bookstore!= null) {
                                    System.out.println("bookname :" + bookstore.getTitle() + "\nauthor: " + bookstore.getAuthor() + "\nprice: " + bookstore.getPrice() + "\nquantity: " + bookstore.getQuantity());
                                } else {
                                    System.out.println("BOOK NOT FOUND");
                                }

                                break;


                            case 4:
                                System.out.print("ENTER BOOKNAME: ");
                                String BookName = sc.next();
                                bookstore= service.checkBook(BookName);
                                if (bookstore != null) {
                                    System.out.println("ENTER QUANTITY : ");
                                    int quantity= sc.nextInt();
                                    double k = service.placeOrder(BookName, quantity);
                                    if (k != -1) {
                                        double Amount = service.checkBalance(username, password,creditCardNumber, amount, k * quantity);
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
                                service.ViewAllBooks();
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
}
