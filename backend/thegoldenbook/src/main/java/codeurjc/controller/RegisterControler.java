package codeurjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import codeurjc.repository.UserRepository;
import codeurjc.model.User;

@Controller
public class RegisterControler {
    @Autowired
    private UserRepository user_repository;
    
    public void run(){
        user_repository.save(new User("Chloe", "O'Brian"));
    }
}
