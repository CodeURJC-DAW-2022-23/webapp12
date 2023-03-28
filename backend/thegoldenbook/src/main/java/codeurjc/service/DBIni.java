package codeurjc.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import codeurjc.model.User;
import codeurjc.repository.UserRepository;
import codeurjc.model.Author;
import codeurjc.repository.AuthorRepository;
import codeurjc.model.Book;
import codeurjc.repository.BookRepository;
import codeurjc.model.Review;
//import codeurjc.repository.ReviewRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.hibernate.engine.jdbc.BlobProxy;

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
        Author author1 = new Author("Laura", "Gallego", "Autora española de literatura juvenil, especializada en temática fantástica. Estudió Filología Hispánica en la Universidad de Valencia y en 1999 ganó el premio El Barco de Vapor con Finis Mundi, una novela ambientada en la Edad Media."); 
        Author author2 = new Author("Stephen", "King", "Escritor estadounidense de novelas de terror, ficción sobrenatural, misterio, ciencia ficción y literatura fantástica. Sus libros han vendido más de 500 millones de ejemplares, y en su mayoría han sido adaptados al cine y a la televisión.");
        Author author3 = new Author("Rick", "Riordan", "Autor estadounidense. La mayoría de sus libros están basados en la mitologia griega, romana y agipcia, ambientadas en la época actual.");
        Author author4 = new Author("Gema", "Bonnin", "Escritora y traductora española. Estudió Filología Inglesa en la Universidad Complutense de Madrid.");
        Author author5 = new Author("Agatha", "Christie", "Escritora y dramaturga británica, fallecida en 1976, especializada en el genero policial, por cuyo trabajo obtuvo reconocimientoa nivel internacional. Publicó 66 novelas policiacas, 6 novelas rosas y 14 cuentos, además de un par de obras de teatro.");
        
        setAuthorImage(author1, "/static/Images/author1.jpeg");
        setAuthorImage(author2, "/static/Images/author2.jpg");
        setAuthorImage(author3, "/static/Images/author3.jpeg");
        setAuthorImage(author4, "/static/Images/author4.jpeg");
        setAuthorImage(author5, "/static/Images/author5.jpeg");


        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        authorRepository.save(author4);
        authorRepository.save(author5);
        
        //Books
        Book book1 = new Book("Donde los árboles cantan", 15.5, "Cuando el promtido y el padre de Viana han de ir a la guerra contra los bárbaros, ella no puede hacer nama más que esperarlos, y, tal vez, hacer caso a las leyendas que hablan del Gran Bosque, el lugar donde los árboles cantan", 4);
        Book book2 = new Book("Alas Negras", 19.00, "Ahriel ha conseguido su libertad y su venganza, pero aún hay algo que debe hacer. Reanudará la búsqueda de la prisión mágica Gorlian para recuperar lo que dejó atrás. Conseguirlo no será sencillo, pero estaba vez Ahrial no estará sola...", 9);
        Book book3 = new Book("Alas de Fuego", 19.00, "Ahrial, un ángel femenino, lleva junto a la reina Marla desde que esta nació. Cuando descubre una consipiración, es traicionada y encerrada, con sus alas inutilizadas, en la prisión de Gorlian.", 10);
        Book book4 = new Book("El Resplandor", 20.50, "Esa es la palabra que Danny había visto en el espejo. Y, aunque no sabía leer, entendió que era un mensaje de horror.", 3);
        Book book5 = new Book("It", 18.50, "¿Quién o qué mutila y mata a los niños de un pequeño pueblo norteamericano? ¿Por qué llega cíclicamente el horror a Derry en forma de un payaso siniestro que va sembrando la destrucción a su paso?", 10);
        Book book6 = new Book("La pirámide Roja", 15.00, "nos quedan solo unas horas, así que escucha con atención. si estás oyendo esta historia, ya corres peligro. mi hermana Sadie y yo podríamos ser tu única esperanza. No puedo decirte nada más; el resto deberás descubrirlo tú", 10);
        Book book7 = new Book("El trono de Fuego", 15.00, "Quedan solo cinco días para que una gran serpiente engulla el sol y destruya el mundo. después, todo se volverá oscuridad...", 10);
        Book book8 = new Book("La sombra de la serpiente", 15.00, "Genial, esto va de mal en peor. Apofis anda suelto sembrando el terror allí a donde va. Solo nos quedan dos días...", 10);
        Book book9 = new Book("La dama y el dragón", 19.00, "El día que Erika Williamson conocíó a Hayden Knight sintió algo tan fuerte que salió huyendo y conoció a un dragón. Esto la convertirá en la Dama del Dragón, una misteriosa joven abanderada de la justicia a cuya cabeza han puesto precio en el reino.", 10);
        Book book10 = new Book("Los diez negritos", 14.50, "Diez personas sin relación alguna entre sí son reunidas en un misterioso islote de la costa. Tras la primera cena, y sin haber conocido a su anfitrión, los diez comensales son acusados mediante una grabación de un crimen cometido en el pasado.", 10);
        Book book11 = new Book("Muerte en el Nilo", 19.00, "Durante unas placenteras vacaciones en Egipto, el detective Hércoles Poirot coincide con Linnet y Simon, unos conocidos suyos. El encanto de los maravillosos días se rompe cuando Linnet aparece muerta de un disparo en la cabeza.", 10);
        Book book12 = new Book("Asesinato en el Orient Express", 19.00, "Una fuerte tormenta detiene el Orient Express, tren donde viaja Hércules Poirot. En el compartimiento vecino asesinan a Samuel E. Ratchett. Poirot aprovechará para indagar entre los ocupantes del vagón, quienes son los únicos posibles autores del crimen.", 10);

        book1.setAuthor(author1);
        book2.setAuthor(author1);
        book3.setAuthor(author1);
        book4.setAuthor(author2);
        book5.setAuthor(author2);
        book6.setAuthor(author3);
        book7.setAuthor(author3);
        book8.setAuthor(author3);
        book9.setAuthor(author4);
        book10.setAuthor(author5);
        book11.setAuthor(author5);
        book12.setAuthor(author5);

        setBookImage(book1, "/static/Images/book1.jpeg");
        setBookImage(book2, "/static/Images/book2.jpeg");
        setBookImage(book3, "/static/Images/book3.jpeg");
        setBookImage(book4, "/static/Images/book4.jpeg");
        setBookImage(book5, "/static/Images/book5.jpeg");
        setBookImage(book6, "/static/Images/book6.jpeg");
        setBookImage(book7, "/static/Images/book7.jpeg");
        setBookImage(book8, "/static/Images/book8.jpeg");
        setBookImage(book9, "/static/Images/book9.jpeg");
        setBookImage(book10, "/static/Images/book10.jpeg");
        setBookImage(book11, "/static/Images/book11.png");
        setBookImage(book12, "/static/Images/book12.png");


        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
        bookRepository.save(book7);
        bookRepository.save(book8);
        bookRepository.save(book9);
        bookRepository.save(book10);
        bookRepository.save(book11);
        bookRepository.save(book12);

        //Review
        


    }

    public void setAuthorImage(Author author, String classpathResource){
        try{
            author.setImage(true);
            Resource image = new ClassPathResource(classpathResource);
            author.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
        }
        catch(IOException e){

        }
	}

    public void setBookImage(Book book, String classpathResource){
        try{
            book.setImage(true);
            Resource image = new ClassPathResource(classpathResource);
            book.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
        }
        catch(IOException e){
        }
    }
}
