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
import fi.hh.palvelinohjelmointi.Bookstore.domain.User;
import fi.hh.palvelinohjelmointi.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository categoryRepository, UserRepository urepository) {
		return (args) -> {
	
			log.info("save a couple of books and categories");
			categoryRepository.save(new Category("Kauhu"));
			categoryRepository.save(new Category("Huumori"));
			categoryRepository.save(new Category("Jännitys"));
			categoryRepository.save(new Category("Fantasia"));
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Lastenkirjat"));
			categoryRepository.save(new Category("Rakkaus"));
			//repository.save(new Book("Hessun Romaani", "Hessu Hoopo", new Category("Romaani"), "2002", "ISBN1b5asd123", "5.99"));
			//repository.save(new Book("Todella kiva kirja", "Mikko Esimerkki", new Category("Mixi"), "2000", "123-123-1234", "24.99"));
			User user1 = new User("user", "$2a$06$zmBwssLAoceLGcleYf7oGedMAfAabHmWbwpRTtvueWNsQA4QinudW", "USER", "user@palvelinohjelmointi.fi");
			urepository.save(user1);
			User user2 = new User("admin", "$2a$06$QP8rFStipiTPSRNF38e1iuVrLbSINgUkEkU7ZZbQV6lwxd0CdRgAS", "ADMIN", "admin@palvelinohjelmointi.fi");
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
