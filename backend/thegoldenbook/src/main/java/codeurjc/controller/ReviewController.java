package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codeurjc.repository.ReviewRepository;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository review_repository;

    @GetMapping("/review")
    public String review (Model model){
        model.addAttribute("review", review_repository.findAll());
            return "review";
        
    }    
}
