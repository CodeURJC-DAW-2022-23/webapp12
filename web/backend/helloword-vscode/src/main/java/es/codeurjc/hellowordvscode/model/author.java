package es.codeurjc.hellowordvscode.model;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;

	private Blob portrait;
    private String description;

	@OneToMany(mappedBy="Author")
	private List<book> Book;


	public author() {
	}

	public author(String name, String description, Blob portrait) {
		this.name = name;
		this.description = description;
		this.portrait = portrait;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Blob getPortrait(){
        return portrait;
    }

    public void setPortrait(Blob portrait){
        this.portrait = portrait;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
