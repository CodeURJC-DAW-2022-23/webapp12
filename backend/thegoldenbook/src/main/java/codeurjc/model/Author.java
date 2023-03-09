package codeurjc.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String info;

    @Lob
    @JsonIgnore
    private Blob imageFile;
    private boolean image;

    
	@OneToMany(mappedBy = "author")
    private List<Book> books;

	protected Author() {}

	public Author(String firstName, String lastName, String info) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.info = info;
	}

	@Override
	public String toString() {
		//
		return super.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

	public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob imageFile) {
		this.imageFile = imageFile;
	}

	public boolean isImage() {
		return image;
	}

	public void setImage(boolean image) {
		this.image = image;
	}
	
}

