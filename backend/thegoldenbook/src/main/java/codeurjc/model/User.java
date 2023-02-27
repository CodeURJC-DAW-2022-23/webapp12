package codeurjc.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String email;
    private String adress;
    private Long phoneNumber;
    private String password;
    private String favoriteGenre;

    

    @OneToMany(mappedBy = "User")
    private List<Review> reviews;

    public User() {
    }

    public User(String name, String email, String adress, Long phoneNumber, String favoriteGenre,
            String password) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.favoriteGenre = favoriteGenre;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }


    public String getAdress() {
        return adress;
    }



    public void setAdress(String adress) {
        this.adress = adress;
    }


    public Long getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
