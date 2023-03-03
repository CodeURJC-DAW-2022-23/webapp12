package codeurjc.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import codeurjc.model.Author;
import codeurjc.model.Book;
import codeurjc.model.Review;
import codeurjc.model.User;
import codeurjc.repository.AuthorRepository;
import codeurjc.repository.BookRepository;
import codeurjc.repository.UserRepository;
import codeurjc.repository.ReviewRepository;


@RestController
public class DBInit{
    @Autowired
    private AuthorRepository author_repository;
    @Autowired
    private BookRepository book_repository;
    @Autowired
    private UserRepository user_repository;
    @Autowired
    private ReviewRepository review_repository;

    @PostConstruct
    public void init() throws Exception {
        author_repository.save(new Author("Stephen", "King", "Yei"));
        author_repository.save(new Author("Laura", "Gallego", "yeye"));
        user_repository.save (new User("hug", "hug@gmail.com", "pas"));
        user_repository.save(new User("huga", "huga@gmail.com", "pass"));
        book_repository.save(new Book("Juego de tronos", 4, 4, 4, "Ciencia Ficción", "JK Rowling", true, 4));
        book_repository.save(new Book("Harry Potter", 4, 4, 4, "Ciencia Ficción", "JK Rowling", true, 4));
        review_repository.save(new Review(5,"esta bien"));
        review_repository.save(new Review(8,"esta mal"));
        user_repository.save(new User("Harry", "email", "password"));
    }
}