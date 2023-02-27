package codeurjc.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codeurjc.model.Author;
import codeurjc.repository.AuthorRepository;

@Controller
public class AuthorController{

    @Autowired
    private AuthorRepository author_repository;

    @GetMapping("/author")
    public String author(Model model){
        Optional<Author> author = author_repository.findByLastName("King");
        
        if(author.isPresent()){
            model.addAttribute("author", author.get());
        }

        return "author";
    }
}