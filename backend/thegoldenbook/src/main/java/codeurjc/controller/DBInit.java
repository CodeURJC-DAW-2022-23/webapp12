package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import codeurjc.model.Author;
import codeurjc.model.Book;
import codeurjc.model.User;
import codeurjc.repository.AuthorRepository;
import codeurjc.repository.BookRepository;
import codeurjc.repository.UserRepository;



public class DBInit implements CommandLineRunner{
    @Autowired
    private AuthorRepository author_repository;
    @Autowired
    private BookRepository book_repository;
    @Autowired
    private UserRepository user_repository;


    @Override
    public void run(String... args) throws Exception {
        author_repository.save(new Author("Stephen", "King"));
        author_repository.save(new Author("Laura", "Gallego"));
        book_repository.save(new Book("Juego de tronos", 5, 20, 4, 4, "Esta es la descripción"));
        book_repository.save(new Book("Harry Potter", 5, 20, 4, 4, "Esta es la descripción 2"));
        user_repository.save (new User("huga", "huga@gmail.com", "plazo mayor", 609106547, "pass", "dramas"));
        user_repository.save (new User("hugo", "hugo@gmail.com", "plaza mayor", 609102547, "prob", "drama"));
    }
}