package codeurjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import codeurjc.model.Author;
import codeurjc.repository.AuthorRepository;

public class DBInit implements CommandLineRunner{
    @Autowired
    private AuthorRepository author_repository;
    @Override
    public void run(String... args) throws Exception {
        author_repository.save(new Author("Stephen", "King"));
        author_repository.save(new Author("Laura", "Gallego"));
    }
}