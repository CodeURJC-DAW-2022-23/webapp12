package codeurjc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import codeurjc.model.Book;
import codeurjc.model.Author;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    @Query("SELECT a, COUNT(b) " +
           "FROM Book b " +
           "JOIN b.author a " +
           "GROUP BY a")
    List<Author> countBooksByAuthor();
}