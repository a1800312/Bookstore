package fi.hh.palvelinohjelmointi.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	private String title;
	private String author;
	private String year;
	@Id
	private String isbn;
	private String price;
	
	public Book() {
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = null;
	}
	
	public Book(String title, String author, String year, String isbn, String price) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
}
