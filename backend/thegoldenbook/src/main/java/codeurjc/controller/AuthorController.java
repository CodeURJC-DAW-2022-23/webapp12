package codeurjc.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codeurjc.model.Author;
import codeurjc.repository.AuthorRepository;


@Controller
public class AuthorController{

    @Autowired
    private AuthorRepository author_repository;

    @GetMapping("/author")
    public String author(Model model){
        author_repository.save(new Author("Stephen", "King", "esto es genial"));
        author_repository.save(new Author("Laura", "Gallego", "esto tanbien es genial"));
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

    @GetMapping("/authorModification")
    public String authorModification(Model model){
        return "authorModification";
    }


    @PostMapping("/authorModification")
    public String newAuthorModification(Model model, Author author) throws IOException{

        


        author_repository.save(author);

        return "redirect:/author/";

    }

}