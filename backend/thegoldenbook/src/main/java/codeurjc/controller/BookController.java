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
import org.springframework.web.bind.annotation.RequestParam;

import codeurjc.model.Book;
import codeurjc.repository.BookRepository;

@Controller
public class BookController{

    @Autowired
    private BookRepository book_repository;

    @GetMapping("/book")
    public String book(Model model){
      book_repository.save(new Book("Fuego y sangre", 5, 20.95, 2, "George R. R. Martin"));
      book_repository.save(new Book("Harry Potter y el misterio del príncripe", 5, 19.80, 4, "J. K. Rowling"));
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

    /*@GetMapping("/static/image") 
    public String viewImage(Model model) { 
      model.addAttribute("imageName", imageName); 
      return "view_image"; 
    } 
    
    @GetMapping("/download_image") 
    public ResponseEntity<Object> downloadImage(Model model) throws MalformedURLException {
       Path imagePath = IMAGES_FOLDER.resolve("image.jpg"); 
       Resource image = new UrlResource(imagePath.toUri()); 
       return ResponseEntity.ok() 
       .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") 
       .body(image); }
    }*/