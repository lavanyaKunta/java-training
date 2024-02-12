package User;

import BookStore.Book;

import java.util.ArrayList;

import static DETAILS.Details.books;
import static DETAILS.Details.users;

public class UserService {
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
