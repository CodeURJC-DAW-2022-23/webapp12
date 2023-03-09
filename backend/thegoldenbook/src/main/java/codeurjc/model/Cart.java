package codeurjc.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //private int amounthTotal;
    private double total; 

    public Cart() {}

    public Cart(double total){
        //this.amounthTotal = amounthTotal;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*public int getAmounthTotal() {
        return amounthTotal;
    }

    public void setAmounthTotal(int amounthTotal) {
        this.amounthTotal = amounthTotal;
    }
    */
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
