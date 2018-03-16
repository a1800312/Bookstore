package fi.hh.palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.palvelinohjelmointi.Bookstore.domain.Book;
import fi.hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import fi.hh.palvelinohjelmointi.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository bRepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bRepository.findBookByTitle("Hessun Romaani");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Hessu Hoopo");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Kauheat haamut", "Esa Pirkkanen", new Category("KAUHU"), "2012", "123-456-1111", "12.99");
		bRepository.save(book);
		assertThat(book.getTitle()).isNotEmpty();
		assertThat(book.getAuthor()).isNotEmpty();
		assertThat(book.getCategory()).isNotNull();
		assertThat(book.getYear()).isNotEmpty();
		assertThat(book.getIsbn()).isNotEmpty();
		assertThat(book.getPrice()).isNotEmpty();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = bRepository.findBookByIsbn("123-123-1234");
		bRepository.delete(books);
		assertThat(books.get(0).getIsbn()).isEmpty();
	}

}
