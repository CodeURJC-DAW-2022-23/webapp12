package es.codeurjc.hellowordvscode.model;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class book {

    @Id
    private String title;

    //Clave ajena para autor
    private String author;

    private int stock;
    private int price;
    private String sinopsis;

    public book() {
	}

	public book(String title, String author) {
		this.title = title;
		this.author = author;
	}
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}