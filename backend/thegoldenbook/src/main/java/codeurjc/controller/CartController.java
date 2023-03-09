package codeurjc.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import codeurjc.model.Book;
import codeurjc.model.Cart;
import codeurjc.repository.CartRepository;

@Controller
public class CartController {

    @Autowired  
    private CartRepository cart_repository;
    
    @GetMapping("/cart/{id}")
    public String book(Model model, @PathVariable long id){
        model.addAttribute("bookCart", cart_repository.findAll());
    return "cart";
    }
    
    @PostMapping("/newBook")
    public String newBookProcess(Model model, Book book, MultipartFile imageField) throws IOException {
  
      if (!imageField.isEmpty()) {
        book.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
        book.setImage(true);
      }
  
      cart_repository.save(book);
  
      model.addAttribute("id", book.getId());
  
      return "redirect:/cart";
    }

}
