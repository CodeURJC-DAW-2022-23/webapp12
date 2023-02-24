package codeurjc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class shellTitleAuthor implements Serializable {

    @Column
    private String title;

    @Column
    private String author;

    public shellTitleAuthor() {
    }

    public shellTitleAuthor(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

   
}

