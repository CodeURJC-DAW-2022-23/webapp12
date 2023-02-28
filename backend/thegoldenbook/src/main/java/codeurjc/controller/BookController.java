package codeurjc.controller;

import java.net.MalformedURLException;
import java.net.http.HttpHeaders;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codeurjc.model.Book;
import codeurjc.repository.BookRepository;

@Controller
public class BookController{

    @Autowired
    private BookRepository book_repository;

    @RequestMapping("/book")
    public String book(Model model, @RequestParam String email){
      model.addAttribute("bookList", book_repository.findAll());
      model.addAttribute("email", email);
    return "home";
    }

    @GetMapping("/book/{id}")
    public String bookInfo(Model model, @PathVariable long id){
      Optional<Book> book = book_repository.findById(id);
        if (book.isPresent()){
            model.addAttribute("book", book.get());
        }
        return "bookInfo";
    }
  }