package codeurjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity 
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int  calification;
    private String text;

    @ManyToOne
    private User User;

    @ManyToOne
    private Book Book;

    public Review() {
    }

    public Review(int calification, String text) {
        this.calification = calification;
        this.text = text;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
