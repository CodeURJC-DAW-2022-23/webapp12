package codeurjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
<<<<<<< HEAD


=======
>>>>>>> 8ce2de4c8c075fbfaf947167264c350a7bec113a

@Entity 
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int  valoracion;
    private String text;

    //@ManyToOne
    //private User user;

    //@ManyToOne
    //private Book Book;

    public Review() {
    }

    public Review(int calification, String text, User user) {
        this.valoracion = calification;
        this.text = text;
        this.user = user;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int calification) {
        this.valoracion = calification;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    } 
}
