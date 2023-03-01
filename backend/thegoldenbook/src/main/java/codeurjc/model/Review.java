package codeurjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int calification;
    private String text;

    public Review() {}

    public Review(int calification, String text) {
        this.calification = calification;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


