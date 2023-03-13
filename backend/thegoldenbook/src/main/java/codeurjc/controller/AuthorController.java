package codeurjc.controller;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import codeurjc.model.Author;
import codeurjc.model.Book;
import codeurjc.repository.AuthorRepository;


@Controller
public class AuthorController{

    @Autowired
    private AuthorRepository author_repository;

    @GetMapping("/author")
    public String author(Model model,  HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        model.addAttribute("authorList", author_repository.findAll());
        return "authorList";
    }

    @GetMapping("/author/{id}")
    public String showAuthor(Model model, @PathVariable long id, HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));

        Optional<Author> author = author_repository.findById(id);
        if (author.isPresent()){
            model.addAttribute("author", author.get());
        }
        return "author";
    }

    @GetMapping("/authorModification")
    public String authorModification(Model model,HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        return "authorModification";
    }

    @PostMapping("/authorModification")
    public String newAuthorProcess(Model model, Author author, MultipartFile imageField) throws IOException {
  
        if (!imageField.isEmpty()) {
          author.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
          author.setImage(true);
        }
    
        author_repository.save(author);
    
        model.addAttribute("id", author.getId());
    
        return "redirect:/author";
    }

    @GetMapping("auhtor/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException, IOException {

        Optional<Author> author = author_repository.findById(id);
        if (author.isPresent() && author.get().getImageFile() != null) {

            InputStreamResource file = new InputStreamResource(author.get().getImageFile().getBinaryStream());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg", "image/jpg")
                  .contentLength(author.get().getImageFile().length()).body(file);

        } else {
            return ResponseEntity.notFound().build();
        }
  }
} 