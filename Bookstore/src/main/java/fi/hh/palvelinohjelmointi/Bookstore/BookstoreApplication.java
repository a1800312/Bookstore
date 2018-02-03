package fi.hh.palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.palvelinohjelmointi.Bookstore.domain.Book;
import fi.hh.palvelinohjelmointi.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Book("Kirjan nimi esimerkki", "Kirjoittajan nimi", "2002", "ISBN1b5asd123", "5.99"));
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
