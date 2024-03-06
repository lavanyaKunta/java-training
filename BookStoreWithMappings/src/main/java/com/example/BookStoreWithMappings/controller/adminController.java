package com.example.BookStoreWithMappings.controller;

import com.example.BookStoreWithMappings.entity.Admin;
import com.example.BookStoreWithMappings.entity.Book;
import com.example.BookStoreWithMappings.entity.User;
import com.example.BookStoreWithMappings.entity.Cart;
import com.example.BookStoreWithMappings.models.*;
import com.example.BookStoreWithMappings.service.*;
import com.example.BookStoreWithMappings.validitaion.adminValidation;
import com.example.BookStoreWithMappings.validitaion.userValidation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class adminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    userValidation valid;
    @Autowired
    adminValidation adminValid;
    @Autowired
    CartServices cartServices;
    @Autowired
    OrderService orderService;
    int id;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/adminDashboard")
    public String adminDashboard(){
        return "adminDashboard";
    }
    @RequestMapping("/adminRegisterForm")
    public String adminRegisterForm(Model model){
        AdminModel adminModel=new AdminModel();
        model.addAttribute("adminModel",adminModel);
        return "adminRegisterForm";
    }
    @RequestMapping("/registerAdmin")
    public String adminRegister(@Valid @ModelAttribute("adminModel")AdminModel adminModel,BindingResult bindingResult, ModelMap model){
        adminValid.validate(adminModel,bindingResult);
        if(bindingResult.hasErrors()){
            return "adminRegisterForm";
        }
        Admin admin=adminService.adminRegister(adminModel.getAdminId(),adminModel.getAdminPassword());
        if(admin==null)
            return "userExist";
        model.addAttribute("admin",admin);
        return "adminLoginForm";
    }
    @RequestMapping("/adminLoginForm")
    public String adminLoginForm(Model model){
        AdminModel adminModel=new AdminModel();
        model.addAttribute("adminModel",adminModel);
        return "adminLoginForm";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@Valid @ModelAttribute("adminModel")AdminModel adminModel,BindingResult bindingResult,ModelMap model){
        adminValid.validateAdminLogin(adminModel,bindingResult);
        if(bindingResult.hasErrors()){
            return "adminLoginForm";
        }
        if(adminService.authenticate(adminModel.getAdminId(),adminModel.getAdminPassword())){
            model.addAttribute("adminId",adminModel.getAdminId());
            return "adminDashboard";
        }
        else{
            return "redirect:/adminLoginForm";
        }


}
    @RequestMapping("/addBook")
    public String addBook(@RequestParam("adminId")int adminId,ModelMap mp){
        mp.addAttribute("adminId",adminId);
        System.out.println(adminId);
        return "addBook";
    }
    @RequestMapping("/addBookResult")
    public String addBookResult(BookModel bookModel, int adminId, HttpServletRequest request, ModelMap map){

        BookModel b=bookService.addBook(bookModel,adminId);
        if(b==null){
            return "userExist";
        }
        map.addAttribute("book",b);
        map.addAttribute("adminId",adminId);
        return "adminDashboard";
    }
    @RequestMapping("/viewAdminBooks")
    public String viewAdminBooks(@RequestParam("adminId")int adminId,ModelMap map){
        List<BookModel> bookList= bookService.getAdminBooks(adminId);
        map.addAttribute("bookList",bookList);
        map.addAttribute("adminId",adminId);
//        map.addAttribute("bookId",bookId);
        return "viewAdminBooks";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(int adminId,@RequestParam("BookId")int bookId,ModelMap model){
        Book book=bookService.deletingBook(bookId);
        model.addAttribute("book",book);
        model.addAttribute("adminId",adminId);
        return "adminDashboard";
    }
    @RequestMapping("/increaseBookQuantity")
    public String increaseQuantity(@RequestParam("adminId") int adminId,@RequestParam("bookId") int bookId,ModelMap model){
        model.addAttribute("adminId",adminId);
        model.addAttribute("bookId",bookId);
        return "quantityForm";
    }
    @RequestMapping("/increaseQuantityResult")
    public String increaseQuantityResult(int adminId,@RequestParam("bookId") int bookId,@RequestParam("bookQuantity")int quantity, ModelMap model){
        model.addAttribute("adminId",adminId);
        Book book=bookService.increaseQuantity(bookId,quantity);
        model.addAttribute("book",book);
        return "adminDashboard";
    }
    @RequestMapping("/decreaseBookQuantity")
    public String decreaseQuantity(@RequestParam("adminId") int adminId,@RequestParam("bookId") int bookId,ModelMap model){
        model.addAttribute("adminId",adminId);
        model.addAttribute("bookId",bookId);
        return "decreaseForm";
    }
    @RequestMapping("/decreaseQuantityResult")
    public String decreaseQuantityResult(int adminId,@RequestParam("bookId") int bookId,@RequestParam("bookQuantity")int quantity, ModelMap model){
        Book book=bookService.decreaseQuantity(bookId,quantity);
        model.addAttribute("adminId",adminId);
        if(book==null){
            return "adminDashboard";
        }
        model.addAttribute("book",book);
        return "adminDashboard";
    }
    @RequestMapping("/updateBook")
    public String updateBook(int adminId,@RequestParam("bookId")int bookId,ModelMap model){
        model.addAttribute("bookId",bookId);
        model.addAttribute("adminId",adminId);
        return "updateBookForm";
    }
    @RequestMapping("/updateBookResult")
    public String updateBookResults(int adminId,Book book,ModelMap model){
        Book b=bookService.updateBook(book);
        model.addAttribute("book",b);
        model.addAttribute("adminId",adminId);
        return "adminDashboard";
    }






//    ------------------------------user-----------------------
    @RequestMapping("/user")
    public String user(){
    return "user";
}

    @RequestMapping("/userDashboard")
    public String userDashboard(){
        return "userDashboard";
    }
    @RequestMapping("/userRegisterForm")
    public String userRegisterForm(Model model){
        UserModel userModel=new UserModel();
        model.addAttribute("userModel",userModel);
        return "userRegisterForm";
    }
    @RequestMapping("/registerUser")
    public String userRegister(@Valid @ModelAttribute("userModel")UserModel userModel, BindingResult bindingResult, ModelMap model){
       valid.validate(userModel,bindingResult);
//        System.out.println(bindingResult.getAllErrors());
       if(bindingResult.hasErrors())
           return "userRegisterForm";

        User user=userService.userRegister(userModel);
        if(user==null)
            return "userExist";
        model.addAttribute("user",user);
        return "userLoginForm";
    }
    @RequestMapping("/userLoginForm")
    public String userLoginForm(Model model){
        UserModel userModel=new UserModel();
        model.addAttribute("userModel",userModel);
        return "userLoginForm";
    }

    @RequestMapping("/userLogin")
    public String userLogin(@Valid @ModelAttribute("userModel")UserModel userModel,BindingResult bindingResult,ModelMap model){
        valid.validateLogin(userModel,bindingResult);
        if(bindingResult.hasErrors()){
            return "userLoginForm";
        }
        if(userService.authenticate(userModel.getUserId(),userModel.getPassword())){
            model.addAttribute("userId",userModel.getUserId());
            return "userDashboard";
        }
        else{
            return "redirect:/userLoginForm";
        }
    }
    @RequestMapping("/viewAllBooks")
    public String getAllbooks(@RequestParam("userId") int userId,ModelMap map){
        List<BookModel> books=bookService.getAllBooks();
        map.addAttribute("books",books);
        map.addAttribute("userId",userId);
        return "viewAllBooks";
    }

    @RequestMapping("/AddToCart")
    public String addToCart(@RequestParam("userId")int userId,@RequestParam("BookId")int bookId,ModelMap model){
        Book book=bookService.searchBook(bookId);
        System.out.println(book);
        User user=userService.searchUser(userId);
        System.out.println(user);
        if(book!=null&&user!=null){
            CartModel cartModel=cartServices.addToCart(book,user);
            System.out.println(cartModel);
            if(cartModel!=null){
                int cartId=cartModel.getCartId();
                model.addAttribute("cartId",cartId);
                model.addAttribute("userId",userId);
                return "userDashboard";
            }

        }
          model.addAttribute("userId",userId);
        return "userDashboard";
    }
    @RequestMapping("/viewCart")
    public String viewCart(@RequestParam("userId")int userId,ModelMap model){
        User user=userService.searchUser(userId);
        if(user!=null) {
            int cartId = user.getCart().getCartId();
            List<Book> cartList=cartServices.getAllBooks(cartId);
            System.out.println("-------------------------------------------------------");
            System.out.println(cartList);

            if(cartList!=null){
                model.addAttribute("cartList",cartList);
                model.addAttribute("userId",userId);
                model.addAttribute("cartId",cartId);
                return "viewCart";
            }
        }

        return null;
    }
    @RequestMapping("/buyBook")
    public String buyBook(int userId,int bookId,int cartId,ModelMap map){
        map.addAttribute("bookId",bookId);
        map.addAttribute("userId",userId);
        map.addAttribute("cartId",cartId);
        return "quantity";
    }

    @RequestMapping("/buyBookResult")
    public String buyBookResult(@RequestParam("userId")int userId,@RequestParam("bookId")int bookId,@RequestParam("bookQuantity")int quantity,@RequestParam("cartId")int cartId, ModelMap model){
        List<Book> bookList=orderService.orders(userId,bookId,quantity,cartId);
        model.addAttribute("orderModel",bookList);
        return "viewOrders";
    }

}
