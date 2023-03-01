package codeurjc.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private int stock;
    private double price;
    private int nValoracion;
    private String author;
    
    /*@OneToMany (mappedBy = "Book")
    private List<Review> Reviews;

    @OneToOne (mappedBy = "Book")
    private Author author;*/

    public Book() {}
    

    public Book(String title, int stock, double price, int nValoracion, String author){
        this.title = title;
        this.stock = stock;
        this.price = price;
        this.author = author;
    }  

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }  
}
