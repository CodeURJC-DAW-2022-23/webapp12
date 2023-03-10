package codeurjc.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import codeurjc.model.Book;
import codeurjc.model.Cart;
import codeurjc.repository.CartRepository;

@Controller
public class CartController {

    @Autowired  
    private CartRepository cart_repository;
    @Autowired
    private BookController bookController;
    @Autowired
    private UserControler userControler;

    @GetMapping("/cart")
    public String showCart (Model model, HttpServletRequest request){
      model.addAttribute("admin", request.isUserInRole("ADMIN"));
      model.addAttribute("bookCart", cart_repository.findAll());
    return "cart";
    }

    @PostMapping("/addbooktocart/{bookId}")
    public String addToCart (Model model, @RequestParam String bookId, HttpServletRequest request){


      //Book book = bookRepository.findById(bookId)

    //user.getCart().addToCart()

    return "cart";
    }
}
