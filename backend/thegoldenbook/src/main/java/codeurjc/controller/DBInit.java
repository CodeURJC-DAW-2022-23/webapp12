package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import codeurjc.model.Author;
import codeurjc.model.Book;
import codeurjc.model.Review;
import codeurjc.model.User;
import codeurjc.repository.AuthorRepository;
import codeurjc.repository.BookRepository;
import codeurjc.repository.UserRepository;
import codeurjc.repository.ReviewRepository;



public class DBInit implements CommandLineRunner{
    @Autowired
    private AuthorRepository author_repository;
    @Autowired
    private BookRepository book_repository;
    @Autowired
    private UserRepository user_repository;
    @Autowired
    private ReviewRepository review_repository;


    @Override
    public void run(String... args) throws Exception {
        author_repository.save(new Author("Stephen", "King"));
        author_repository.save(new Author("Laura", "Gallego"));
        //book_repository.save(new Book("Juego de tronos", 5, 20, 4, 4, "Esta es la descripción"));
        //book_repository.save(new Book("Harry Potter", 5, 20, 4, 4, "Esta es la descripción 2"));
        user_repository.save (new User("hug", "hug@gmail.com", "plazo ", 609106587, "pas", "dras"));
        user_repository.save(new User("huga", "huga@gmail.com", "plazo mayor", 609106547, "pass","dramas"));
        review_repository.save(new Review(5,"esta bien"));
        review_repository.save(new Review(8,"esta mal"));
    }
}