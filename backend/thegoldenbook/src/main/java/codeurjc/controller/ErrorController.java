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
public class ErrorController {

    @Autowired
    private ErrorRepository review_repository;

    @GetMapping("/error")
    public String error (Model model){
            return "/error";
        
    }    
}