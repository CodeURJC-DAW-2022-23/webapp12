package codeurjc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import codeurjc.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
   Optional<Author> findByLastName(String lastName);
    List<Author> findByFirstName(String firstName); 
}
