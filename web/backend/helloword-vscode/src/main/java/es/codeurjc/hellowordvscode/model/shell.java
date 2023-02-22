package es.codeurjc.hellowordvscode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity 
@Table(name = "ShellTable")
public class shell implements Serializable { 

    @EmbeddedId
    private shellTitleAuthor ShellTitleAuthor;

    @Column
    private String user;

    @ManyToMany(mappedBy="Shell")
    private List<book> Book;

    public shell() {
    }

    public shell(shellTitleAuthor shellTitleAuthor, String user) {
        ShellTitleAuthor = shellTitleAuthor;
        this.user = user;
    }

    public shellTitleAuthor getShellTitleAuthor() {
        return ShellTitleAuthor;
    }

    public void setShellTitleAuthor(shellTitleAuthor shellTitleAuthor) {
        ShellTitleAuthor = shellTitleAuthor;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}

