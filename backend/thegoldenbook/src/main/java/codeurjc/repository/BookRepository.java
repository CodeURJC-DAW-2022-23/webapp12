package codeurjc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import codeurjc.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
