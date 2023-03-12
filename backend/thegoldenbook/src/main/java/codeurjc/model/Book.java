package codeurjc.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.lang.Nullable;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private double price;
    private String info;
    private int stock;
    private int totalValoration;
    //private int reviewAVG;
    
    @ManyToOne
    private Author author;

    @ManyToOne 
    @JoinColumn(name = "cartId")
    private Cart cart;

    
    @Nullable
    @OneToMany
    private List<Review> reviews;
    

    @Lob
    @JsonIgnore
    private Blob imageFile;
    private boolean image;


    public Book() {}
    
    public Book(String title, double price, String info, int stock){
        this.title = title;
        this.price = price;
        this.info = info;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
    }
    
    public boolean getImage(){
        return image;
    }

    public void setImage(boolean image){
        this.image = image;
    }
    public int getTotalValoration() {
        return totalValoration;
    }

    public void setValoracion(int totalValoration) {
        this.totalValoration = totalValoration;
    }
    
    public void addReview(Review review){
        this.reviews.add(review);
        this.totalValoration = (totalValoration+review.getValoracion())/reviews.size();
    }
    
}
