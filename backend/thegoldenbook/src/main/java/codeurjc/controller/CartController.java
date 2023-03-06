package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import codeurjc.repository.SellRepository;

@Controller
public class CartController {

    @Autowired  
    private SellRepository sell_repository;
    
    @GetMapping("/cart")
    public String book(Model model){
        model.addAttribute("bookList", sell_repository.findAll());
    return "cart";
    }
}
