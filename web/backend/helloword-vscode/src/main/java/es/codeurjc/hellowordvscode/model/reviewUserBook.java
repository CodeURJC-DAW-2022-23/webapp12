package es.codeurjc.hellowordvscode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class reviewUserBook implements Serializable {

@Column
private String user;

@Column
private String book;


public reviewUserBook() {
}

public reviewUserBook(String user, String book) {
    super();
    this.user = user;
    this.book = book;
}

public String getUser() {
    return user;
}

public void setUser(String user) {
    this.user = user;
}

public String getBook() {
    return book;
}

public void setBook(String book) {
    this.book = book;
}



}
