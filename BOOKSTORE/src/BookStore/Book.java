package BookStore;

public class Book {
    private  String title;
    private  String author;
    double price;
    private int quantity;
    private  String category;
    public Book(String title, String author, double price, int quantity, String category){
        this.title=title;
        this.author=author;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public void setTitle(String Title){
        title=Title;
    }
    public void setQuantity(int Quantity){
        quantity=Quantity;
        System.out.println("quantity updated: "+quantity);
    }
    public void setPrice(double Price){
        price=Price;
    }



}
