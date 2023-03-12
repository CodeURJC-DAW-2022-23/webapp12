package codeurjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;



@Entity 
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int  Valoracion;
    private String text;

    @Nullable
    @ManyToOne
    private User user;

    

    @Nullable
    @ManyToOne
    private Book Book;

    public Review() {
    }

    public Review(User user, Book book, int valoracion, String text) {
        this.user = user;
        this.Book = book;
        this.Valoracion = valoracion;
        this.text = text;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id  = id;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return Book;
    }

    public void setBook(Book book) {
        Book = book;
    }
    public int getValoracion() {
        return Valoracion;
    }

    public void setValoracion(int valoracion) {
        Valoracion = valoracion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    } 
}
