package codeurjc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codeurjc.model.Book;
import codeurjc.repository.BookRepository;

@Service
public class CargarMasService {

    @Autowired
	private BookRepository book_repository;

	public Optional<Book> findById(long id) {
		return book_repository.findById(id);
	}
	
	public boolean exist(long id) {
		return book_repository.existsById(id);
	}

	public List<Book> findAll() {
		return book_repository.findAll();
	}

	public void save(Book book) {
		book_repository.save(book);
	}

	public void delete(long id) {
		book_repository.deleteById(id);
	}
    
}
