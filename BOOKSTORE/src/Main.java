import java.util.*;

import DETAILS.Details;
import User.User;
import Admin.*;
import BookStore.Book;
import User.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Book bs=new Book();
        Details d=new Details();
        AdminService service=new AdminService();
        UserService uService=new UserService();
        while (true){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("1.Continue   2.Exit ");
            System.out.print("CHOOSE 1 or 2 : ");
            int chooseOption=sc.nextInt();
            if(chooseOption==1){
                System.out.println("1.ADMIN   2.USER");
                System.out.print("CHOOSE FROM ABOVE : ");
                try{
                    int chooseNum=sc.nextInt();
                    System.out.println();
                    switch (chooseNum){
                        case 1:
                            Admin admin=new Admin();
                            service.login();
                            break;
                        case 2:
                            System.out.print("1.REGISTER  2.LOGIN  3.GO BACK :  ");
                            int userChoice=sc.nextInt();
                            User users=new User();
                            switch (userChoice){
                                case 1:
                                    uService.userRegister();
                                    break;
                                case 2:
                                    uService.userLogin();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("INVALID INPUT");
                            }
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(chooseOption==2) {
                break;
            }
            else {
                System.out.println("Invalid Input");
            }
            System.out.println("\n");
        }
    }
}