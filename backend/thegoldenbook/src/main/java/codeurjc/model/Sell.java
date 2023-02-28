/*package codeurjc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity 
@Table(name = "SellTable")
public class Sell { 

    @Column
    private String user;
    private int price;

    @ManyToMany(mappedBy="Sell")
    private List<Book> Book;

    public Sell() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
*/
