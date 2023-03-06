package codeurjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import codeurjc.model.Book;

public interface CartRepository extends JpaRepository<Book, Long> {
    
}
