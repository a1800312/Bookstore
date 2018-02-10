package fi.hh.palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.palvelinohjelmointi.Bookstore.domain.Book;
import fi.hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import fi.hh.palvelinohjelmointi.Bookstore.domain.Category;
import fi.hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
	
			log.info("save a couple of books and categories");
			categoryRepository.save(new Category("Kauhu"));
			categoryRepository.save(new Category("Huumori"));
			categoryRepository.save(new Category("Jännitys"));
			categoryRepository.save(new Category("Fantasia"));
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Lastenkirjat"));
			categoryRepository.save(new Category("Rakkaus"));
			//repository.save(new Book("Kirjan nimi esimerkki", "Kirjoittajan nimi", "2002", "ISBN1b5asd123", "5.99"));
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
