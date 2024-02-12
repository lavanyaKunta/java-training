package Admin;

import BookStore.*;
import DETAILS.Details;

import java.util.*;

public class Admin {
    private String username;
    private String password;
    public Admin(){

    }
    public Admin(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;}


}
