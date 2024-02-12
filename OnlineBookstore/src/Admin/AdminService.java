package Admin;
import BookStore.Book;

import static DETAILS.Details.books;

public class AdminService {
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

