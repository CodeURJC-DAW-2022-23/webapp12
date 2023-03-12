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
        authorRepository.save(new Author("Rick", "Riordan", "Autor estadounidense. La mayoría de sus libros están basados en la mitologia griega, romana y agipcia, ambientadas en la época actual."));
        authorRepository.save(new Author("Gema", "Bonnin", "Escritora y traductora española. Estudió Filología Inglesa en la Universidad Complutense de Madrid."));
        authorRepository.save(new Author("Agatha", "Christie", "Escritora y dramaturga británica, fallecida en 1976, especializada en el genero policial, por cuyo trabajo obtuvo reconocimientoa nivel internacional. Publicó 66 novelas policiacas, 6 novelas rosas y 14 cuentos, además de un par de obras de teatro."));
        //Books
        bookRepository.save(new Book("Donde los árboles cantan", "Laura Gallego", 15.5 , "3", "Cuando el promtido y el padre de Viana han de ir a la guerra contra los bárbaros, ella no puede hacer nama más que esperarlos, y, tal vez, hacer caso a las leyendas que hablan del Gran Bosque, el lugar donde los árboles cantan", 4));
        bookRepository.save(new Book("Alas Negras", "Laura Gallego", 19.00, "3", "Ahriel ha conseguido su libertad y su venganza, pero aún hay algo que debe hacer. Reanudará la búsqueda de la prisión mágica Gorlian para recuperar lo que dejó atrás. Conseguirlo no será sencillo, pero estaba vez Ahrial no estará sola...", 9));
        bookRepository.save(new Book("Alas de Fuego", "Laura Gallego", 19.00, "4", "Ahrial, un ángel femenino, lleva junto a la reina Marla desde que esta nació. Cuando descubre una consipiración, es traicionada y encerrada, con sus alas inutilizadas, en la prisión de Gorlian.", 10));
        bookRepository.save(new Book("El Resplandor", "Stephen King", 20.50, "4", "Esa es la palabra que Danny había visto en el espejo. Y, aunque no sabía leer, entendió que era un mensaje de horror.", 3));
        bookRepository.save(new Book("It", "Stephen King", 18.50, "4", "¿Quién o qué mutila y mata a los niños de un pequeño pueblo norteamericano? ¿Por qué llega cíclicamente el horror a Derry en forma de un payaso siniestro que va sembrando la destrucción a su paso?", 10));
        bookRepository.save(new Book("La pirámide Roja", "Rick Riordan", 15.00, "4", "nos quedan solo unas horas, así que escucha con atención. si estás oyendo esta historia, ya corres peligro. mi hermana Sadie y yo podríamos ser tu única esperanza. No puedo decirte nada más; el resto deberás descubrirlo tú", 10));
        bookRepository.save(new Book("El trono de Fuego", "Rick Riordan", 15.00, "5", "Quedan solo cinco días para que una gran serpiente engulla el sol y destruya el mundo. después, todo se volverá oscuridad...", 10));
        bookRepository.save(new Book("La sombra de la serpiente", "Rick Riordan", 15.00, "4", "Genial, esto va de mal en peor. Apofis anda suelto sembrando el terror allí a donde va. Solo nos quedan dos días...", 10));
        bookRepository.save(new Book("La dama y el dragón", "Gema Bonnin", 19.00, "4", "El día que Erika Williamson conocíó a Hayden Knight sintió algo tan fuerte que salió huyendo y conoció a un dragón. Esto la convertirá en la Dama del Dragón, una misteriosa joven abanderada de la justicia a cuya cabeza han puesto precio en el reino.", 10));
        bookRepository.save(new Book("Los diez negritos", "Agatha Cristie", 14.50, "3", "Diez personas sin relación alguna entre sí son reunidas en un misterioso islote de la costa. Tras la primera cena, y sin haber conocido a su anfitrión, los diez comensales son acusados mediante una grabación de un crimen cometido en el pasado.", 10));
        bookRepository.save(new Book("Muerte en el Nilo", "Agatha Cristie", 19.00, "4", "Durante unas placenteras vacaciones en Egipto, el detective Hércoles Poirot coincide con Linnet y Simon, unos conocidos suyos. El encanto de los maravillosos días se rompe cuando Linnet aparece muerta de un disparo en la cabeza.", 10));
        bookRepository.save(new Book("Asesinato en el Orient Express", "Agatha Cristie", 19.00, "4", "Una fuerte tormenta detiene el Orient Express, tren donde viaja Hércules Poirot. En el compartimiento vecino asesinan a Samuel E. Ratchett. Poirot aprovechará para indagar entre los ocupantes del vagón, quienes son los únicos posibles autores del crimen.", 10));

    }
}
