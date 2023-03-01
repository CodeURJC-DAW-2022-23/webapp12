package codeurjc.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("POST")
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
        author_repository.save(new Author("Stephen", "King"));
        author_repository.save(new Author("Laura", "Gallego"));
        book_repository.save(new Book("HarryPotter", 3, 10));
        book_repository.save(new Book("HarryPotter", 3, 10));
        user_repository.save (new User("hug", "hug@gmail.com", "pas"));
        user_repository.save(new User("huga", "huga@gmail.com", "pass"));
        review_repository.save(new Review(5,"esta bien"));
        review_repository.save(new Review(8,"esta mal"));
    }
}