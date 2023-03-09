package codeurjc.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import codeurjc.model.Book;
import codeurjc.repository.CartRepository;

@Controller
public class CartController {

    @Autowired  
    private CartRepository cart_repository;
    
    @GetMapping("/cart")
    public String book(Model model){
        model.addAttribute("bookList", cart_repository.findAll());
    return "cart";
    }

    @GetMapping("/bookCart/{id}")
    public String bookInfo(Model model, @PathVariable long id, HttpServletRequest request){
        Optional<Book> book = book_repository.findById(id);
          if (book.isPresent()){
              model.addAttribute("book", book.get());
          }
          return "cart";
      }

}
