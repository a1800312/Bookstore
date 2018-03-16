package fi.hh.palvelinohjelmointi.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>{
	
	List<Book> findBookByIsbn(String isbn);
	List<Book> findBookByTitle(String title);

}
