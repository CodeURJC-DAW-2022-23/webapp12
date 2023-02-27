package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import codeurjc.model.Author;
import codeurjc.model.Book;
import codeurjc.repository.AuthorRepository;
import codeurjc.repository.BookRepository;

public class DBInit implements CommandLineRunner{
    @Autowired
    private AuthorRepository author_repository;
    @Autowired
    private BookRepository book_repository;

    @Override
    public void run(String... args) throws Exception {
        author_repository.save(new Author("Stephen", "King"));
        author_repository.save(new Author("Laura", "Gallego"));
        book_repository.save(new Book("Juego de tronos", 5, 20, 4, 4, "Esta es la descripción"));
        book_repository.save(new Book("Harry Potter", 5, 20, 4, 4, "Esta es la descripción 2"));
    }
}