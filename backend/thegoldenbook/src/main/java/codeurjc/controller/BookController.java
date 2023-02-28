package codeurjc.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import codeurjc.model.Book;
import codeurjc.repository.BookRepository;

@Controller
public class BookController{

    @Autowired
    private BookRepository book_repository;

    @GetMapping("/book")
    public String book(Model model){
      book_repository.save(new Book("Juego de tronos", 5, 20, 2, "Author1"));
      book_repository.save(new Book("Harry Potter", 5, 15, 4, "Author2"));
      model.addAttribute("bookList", book_repository.findAll());
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