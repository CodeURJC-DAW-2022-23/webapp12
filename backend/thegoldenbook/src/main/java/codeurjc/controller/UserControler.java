package codeurjc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ch.qos.logback.core.joran.conditional.ElseAction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;


import codeurjc.model.User;
import codeurjc.repository.BookRepository;
import codeurjc.repository.UserRepository;

@Controller
public class UserControler {

    @Autowired
    private UserRepository user_repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        return "login";
    }

    @GetMapping("/loginError")
    public String loginError(Model model, HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        return "loginError";
    }


    @GetMapping("/register")
    public String register (Model model, HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
            return "register";
    }

    
    @PostMapping("/register")
    public String newUser(Model model, @RequestParam String user, @RequestParam String password, @RequestParam String confirmation ) throws IOException{
        //if para comprobar que las dos contraseñas son iguales
        if(password.equals(confirmation) && user_repository.findByUser(user) == null){
            User usr = new User(user, passwordEncoder.encode(password), "USER");
            user_repository.save(usr);
            return "/home";
        }
        else
            return "/registerError";
        
    }

    @GetMapping("/profile")
    public String clientProfile(Model model, HttpServletRequest request) {
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        String name = request.getUserPrincipal().getName();
        User user = user_repository.findByUser(name);
        model.addAttribute("id", user.getId());
        model.addAttribute("user", user.getUser());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }

    @GetMapping("/profileModification")
    public String profileModification (Model model, HttpServletRequest request){ 
      String name = request.getUserPrincipal().getName();
      User user = user_repository.findByUser(name);
      model.addAttribute("user", user.getUser());
      model.addAttribute("id", user.getId());
      model.addAttribute("email", user.getEmail());
      model.addAttribute("image", user.getImage());
      return "profileModification";
    }

    @PostMapping("/profileModification")
    public String profileModProcess(Model model, HttpServletRequest request, User user, MultipartFile imageField)throws IOException, SQLException{
        if (!imageField.isEmpty()){
            user.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            user.setImage(true);
        }
        user_repository.save(user);
        model.addAttribute("user", user.getId());
        return "redirect:/profile";
    }


}
   