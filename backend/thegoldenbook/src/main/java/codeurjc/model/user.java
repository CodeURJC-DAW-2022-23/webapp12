package codeurjc.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "UserTable")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    private String email;

    private String adress;

    private Long phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    private List <String> favoriteGenre;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;


    public user() {
    }

    public user(String name, String email, String adress, Long phoneNumber, List<String> favoriteGenre,
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

    
    public List<String> getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(List<String> favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}