package codeurjc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table(name = "ReviewTable")
public class review implements Serializable  {


    @EmbeddedId
    private reviewUserBook ReviewUserBook;

    @Column
    private int  calification;

    @Column
    private String Text;

    @ManyToOne
    private User User;

    @ManyToOne
    private book Book;

    public review() {
    }

    public review(reviewUserBook reviewUserBook, int calification, String text) {
        ReviewUserBook = reviewUserBook;
        this.calification = calification;
        Text = text;
    }

    public reviewUserBook getReviewUserBook() {
        return ReviewUserBook;
    }

    public void setReviewUserBook(reviewUserBook reviewUserBook) {
        ReviewUserBook = reviewUserBook;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    
    
}
