package codeurjc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;

import javax.persistence.ManyToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String user;
    private String email;
    private String encodedPassword;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;
    
    @Nullable
    @ManyToMany
    private List<Book> cart = new ArrayList<>();

   /* @Nullable
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;*/

    @Lob
    @JsonIgnore
    private Blob imageFile;
    private boolean image;

    private double totalPrice = 0;

    public User() {
    }

    public User(String user, String password, String... roles) {
        this.user = user;
        this.encodedPassword = password;
        this.roles = List.of(roles);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
    }
    
    public boolean getImage(){
        return image;
    }

    public void setImage(boolean image){
        this.image = image;
    }
        
    public List<Book> getCart() {
        return this.cart;
    }
    
    public void setCart(List<Book> cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addBookToCart(Book book) {
        this.cart.add(book);
        this.totalPrice += book.getPrice();
    }

    public void removeGameFromCart(Book book) {
        this.cart.remove(book);
        this.totalPrice -= book.getPrice();
    }

    public void purchase() {
        this.cart.clear();
        this.totalPrice = 0;
    }

}
