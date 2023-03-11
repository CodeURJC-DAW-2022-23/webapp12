package codeurjc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;


import codeurjc.model.User;
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
    public String newUser(Model model, @RequestParam String user, @RequestParam String password) throws IOException{
        //if para comprobar que las dos contraseñas son iguales
        User usr = new User(user, passwordEncoder.encode(password), "USER");
        user_repository.save(usr);
        return "/home";
    }
    

    @GetMapping("/profileModification/{id}")
    public String profileModification (Model model, @PathVariable long id, HttpServletRequest request){ 
        User user = user_repository.findById(id).orElseThrow();
        User userRequest = user_repository.findByUser(request.getUserPrincipal().getName());
        if (user.getId() == userRequest.getId()) {
			return "profileModification";
		}

		
		return "redirect:/error"; 
            
    }



    @PostMapping("/profileModification")
    public String profileModification(Model model, @RequestParam String user, @RequestParam String password,@RequestParam String email,HttpServletRequest request) throws IOException{
        User usr = user_repository.findByUser(request.getUserPrincipal().getName());
        usr.setEmail(email);
        usr.setUser(user);
        usr.setEncodedPassword(password);
        user_repository.save(usr);
  
        return "/profile";
    }


    
    @GetMapping("/profile/{id}")
	public String profile(Model model, @PathVariable long id, HttpServletRequest request) {
		User user = user_repository.findById(id).orElseThrow();
        User userRequest = user_repository.findByUser(request.getUserPrincipal().getName());
		if (user.getId() == userRequest.getId()) {
			return "profile";
		}
		
		return "redirect:/error";
	}

    @GetMapping("/profileModification")
    public String profileModification (Model model){ 
        model.addAttribute("profileModification", user_repository.findAll());
            return "profileModification";
    }


    @GetMapping("/profile")
    public String clientProfile(Model model, HttpServletRequest request) {
        String name = request.getUserPrincipal().getName();
        User user = user_repository.findByUser(name);
        model.addAttribute("id", user.getId());
        model.addAttribute("user", user.getUser());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }
}
   