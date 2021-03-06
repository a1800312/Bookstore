package fi.hh.palvelinohjelmointi.Bookstore.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.palvelinohjelmointi.Bookstore.domain.Book;
import fi.hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import fi.hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexRequest(){
		// do something
		return "/index";
	}
	
    @RequestMapping(value="/login")
    public String login() {	
        return "/login";
    }
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/book/{isbn}", method = RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("isbn") String bookIsbn) {
		return repository.findOne(bookIsbn);
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String booksListed(Model model){
		model.addAttribute("books", repository.findAll());
		return "/booklist";
	}
	
	@RequestMapping(value="/add")
	public String createBook(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook(Book book){
		repository.save(book);
		return "redirect:/booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{isbn}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("isbn") String isbn){
		repository.delete(isbn);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/editbook/{isbn}", method=RequestMethod.GET)
	public String editBook(@PathVariable("isbn") String isbn, Model model){
		model.addAttribute("book", repository.findOne(isbn));
		return "editbook";
	}
	

	
}
