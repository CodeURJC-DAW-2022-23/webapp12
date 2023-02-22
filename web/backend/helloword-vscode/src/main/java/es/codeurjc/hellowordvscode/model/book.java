package es.codeurjc.hellowordvscode.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "bookTable")
public class book  implements Serializable{

    @EmbeddedId
    private bookTitleAuthor BookTitleAuthor;

    @Column
    private int stock;

    @Column
    private int price;

    @Column
    private String synopsis;

    @ManyToOne
    private author Author;
    
    @OneToMany (mappedBy = "Book")
    private List<review> Reviews;

    @ManyToMany
    private List<shell> Shell;

    public book() {
    }

    public book(bookTitleAuthor bookTitleAuthor, int stock, int price, String synopsis) {
        BookTitleAuthor = bookTitleAuthor;
        this.stock = stock;
        this.price = price;
        this.synopsis = synopsis;
    }

    public bookTitleAuthor getBookTitleAuthor() {
        return BookTitleAuthor;
    }

    public void setBookTitleAuthor(bookTitleAuthor bookTitleAuthor) {
        BookTitleAuthor = bookTitleAuthor;
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
