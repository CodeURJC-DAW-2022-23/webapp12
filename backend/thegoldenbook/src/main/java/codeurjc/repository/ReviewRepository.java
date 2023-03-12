package codeurjc.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import codeurjc.model.Review;
import codeurjc.model.User;
import codeurjc.model.Book;

public interface ReviewRepository extends JpaRepository <Review, Long> {
    Optional<Review> findByUserAndGame(User user, Book book);

    @Query("SELECT r FROM Review r WHERE r.book = :book AND r.user <> :user")
    Page<Review> findByBookAndNotUser(Book book, User user, Pageable pageable);

    Page<Review> findByBook(Book book, Pageable pageable);

    public int countByBook(Book book);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.book = :book AND r.user <> :user")
    public int countByBookAndNotUser(Book book, User user);

}
