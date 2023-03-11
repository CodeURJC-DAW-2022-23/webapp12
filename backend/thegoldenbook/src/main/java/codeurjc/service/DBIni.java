package codeurjc.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import codeurjc.model.User;
import codeurjc.repository.UserRepository;
import codeurjc.model.Author;
import codeurjc.repository.AuthorRepository;
import codeurjc.model.Book;
import codeurjc.repository.BookRepository;

@Service
public class DBIni {
    
	@Autowired
	private UserRepository userRepository;

    @Autowired
	private BookRepository bookRepository;

    @Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDataBase(){
        userRepository.save(new User("user", passwordEncoder.encode("pass"), "USER"));
        userRepository.save(new User("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
        
        //Authors
        authorRepository.save(new Author("Laura", "Gallego", "Autora española de literatura juvenil, especializada en temática fantástica. Estudió Filología Hispánica en la Universidad de Valencia y en 1999 ganó el premio El Barco de Vapor con Finis Mundi, una novela ambientada en la Edad Media.")); 
        authorRepository.save(new Author("Stephen", "King", "Escritor estadounidense de novelas de terror, ficción sobrenatural, misterio, ciencia ficción y literatura fantástica. Sus libros han vendido más de 500 millones de ejemplares, y en su mayoría han sido adaptados al cine y a la televisión."));

        //Books
        bookRepository.save(new Book("Donde los árboles cantan", "Laura Gallego", 15.5 , "3", "Viana, hija única del duque Rocagrís, está prometida al joven robian de Castelmar desde que eran niños. Los dos se aman y se casarán en primavera. Sin embargo, durante los festejos del solsticio de invierno los bárbaros de las estepas comienzan la guerra y tanto Robian como el duque se ven obligados a luchar. En esas circunstancias una doncella como viana no puede hacer otra cosa que esperar su regreso... y, tal vez, prestar atención a las leyendas que se cuentas sobre el Gran Bosque... el lugar donde los árboles cantan.", 5));
    }
}
