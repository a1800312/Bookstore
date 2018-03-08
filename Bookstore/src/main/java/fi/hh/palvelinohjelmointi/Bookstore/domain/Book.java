package fi.hh.palvelinohjelmointi.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	private String title;
	private String author;
	private String year;
	@Id
	private String isbn;
	private String price;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id")
	private Category category;
	
	public Book() {
	}
	
	public Book(String title, String author, Category category, String year, String isbn, String price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book(String title, String author, String year, String isbn, String price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
				+ ", category=" + category + "]";
	}
	
}
