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

}
