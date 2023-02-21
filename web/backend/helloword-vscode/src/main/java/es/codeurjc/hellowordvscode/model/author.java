package es.codeurjc.hellowordvscode.model;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="authors")
public class author {

	@Id
	private String name;

	private Blob portrait;
    private String description;


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 
    public Blob getPortrait(){
        return portrait;
    }

    public void setPortrait(Blob portrait){
        this.portrait = portrait;
    }
}