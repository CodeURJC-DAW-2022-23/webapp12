package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codeurjc.repository.UserRepository;

@Controller
public class UserControler {

    @Autowired
    private UserRepository user_repository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /*
    @GetMapping("/profile")
    public String profile (Model model){ 
        model.addAttribute("profile", user_repository.findAll());
            return "profile";
    }
    @GetMapping("/profileModification")
    public String profileModification (Model model){ 
        model.addAttribute("profileModification", user_repository.findAll());
            return "register";
    }
    @GetMapping("/register")
    public String register (Model model){ 
        model.addAttribute("register", user_repository.findAll());
            return "register";
    }


    @GetMapping("/Header")
    public String Header (Model model){ 
        model.addAttribute("Header", user_repository.findAll());
            return "Header";
    }
    @GetMapping("/Footer")
    public String Footer (Model model){ 
        model.addAttribute("Footer", user_repository.findAll());
            return "Footer";
    }
    @GetMapping("/cart")
    public String cart (Model model){ 
        model.addAttribute("cart", user_repository.findAll());
            return "cart";
    }

*/
;

}
   