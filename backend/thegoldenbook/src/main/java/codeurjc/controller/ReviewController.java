package codeurjc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codeurjc.model.Review;
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
    @GetMapping("addReview")
    public String addReview (Model model){
        model.addAttribute("review", review_repository.findAll());
            return "addReview";
        
    } 

    @PostMapping("/addReview")
    public String newReview(Model model, Review review) throws IOException{

        review_repository.save(review);

        return "redirect:/review";

    }
    @RequestMapping("/addReview")
    public String newReview(@RequestParam int Valoracion, @RequestParam String text ){
        return "review";
    }

}
