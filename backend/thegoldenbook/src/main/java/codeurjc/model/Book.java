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
@Table (name = "Book")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private int stock;
    private int price;
    private int rateYO;
    private int Valoracion;
    private String synopsis;
    
    @OneToMany (mappedBy = "Book")
    private List<Review> Reviews;

    @OneToOne (mappedBy = "Book")
    private Author author;

    public Book() {}
    

    public Book(String title, int stock, int price, int rateYO, int nValoracion, String synopsis){
        this.title = title;
        this.stock = stock;
        this.price = price;
        this.synopsis = synopsis;
    }   

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }  
}
