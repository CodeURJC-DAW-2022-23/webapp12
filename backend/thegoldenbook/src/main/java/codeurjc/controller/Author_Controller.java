package codeurjc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codeurjc.repository.AuthorRepository;

@Controller
public class Author_Controller{

    @Autowired
    private AuthorRepository authorRepository;

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