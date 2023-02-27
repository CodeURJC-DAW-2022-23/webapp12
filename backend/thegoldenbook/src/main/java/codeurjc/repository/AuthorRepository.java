package codeurjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import codeurjc.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByLastName(String lastName);
    List<Author> findByFistName(String firstName);
}
