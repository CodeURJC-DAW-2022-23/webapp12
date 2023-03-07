package codeurjc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import codeurjc.model.Book;
import codeurjc.repository.BookRepository;

@Controller
public class BookController{

    @Autowired
    private BookRepository book_repository;

    @GetMapping("/home")
    public String book(Model model){
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

    @GetMapping("/newBook")
    public String newBook(Model model){
      return "newBook";
    }

    @PostMapping("/newBook")
    public String newBookProcess(Model model, Book book, MultipartFile imageField) throws IOException {
  
      if (!imageField.isEmpty()) {
        book.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
        book.setImage(true);
      }
  
      book_repository.save(book);
  
      model.addAttribute("id", book.getId());
  
      return "redirect:/home";
    }
    
    @GetMapping("/{id}/image")
	  public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException, IOException {

		  Optional<Book> book = book_repository.findById(id);
		  if (book.isPresent() && book.get().getImageFile() != null) {

			  InputStreamResource file = new InputStreamResource(book.get().getImageFile().getBinaryStream());

			  return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg", "image/jpg")
					.contentLength(book.get().getImageFile().length()).body(file);

		  } else {
			  return ResponseEntity.notFound().build();
		  }
	}
	}