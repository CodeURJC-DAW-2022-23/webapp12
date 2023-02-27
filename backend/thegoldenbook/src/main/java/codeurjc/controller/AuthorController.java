package codeurjc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import codeurjc.model.Author;
import codeurjc.repository.AuthorRepository;

@Controller
public class AuthorController{

    @Autowired
    private AuthorRepository author_repository;

    @GetMapping("/author")
    public String author(Model model){
        author_repository.save(new Author("Stephen", "King"));
        author_repository.save(new Author("Laura", "Gallego"));
        model.addAttribute("authorList", author_repository.findAll());
        return "authorList";
    }

    @GetMapping("/author/{id}")
    public String showAuthor(Model model, @PathVariable long id){
        Optional<Author> author = author_repository.findById(id);
        if (author.isPresent()){
            model.addAttribute("author", author.get());
        }
        return "author";
    }
}