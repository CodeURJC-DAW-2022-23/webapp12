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

    @Override
    public void run(String.)
    @GetMapping("/modifyAuthor")
    public String modifyAuthor(Model model){
        return "modifyAuthor";
    }
    @GetMapping("/author")
    public String author(Model model){
        model.addAttribute("name","Stephen King");
        model.addAttribute("info", "text");
        return "author";
    }
}