package edu.cs.uga.project.web.dto;

import java.util.Properties;
/*
import edu.cs.uga.project.model.InternetAddress;
import edu.cs.uga.project.model.MessagingException;
import edu.cs.uga.project.model.MimeMessage;
import edu.cs.uga.project.model.PasswordAuthentication;
import edu.cs.uga.project.model.Session;
*/
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Column;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.util.UserState;


public class BookDto {
	private long bookID;

	private String category;

	private String authors;
	private String title;
	private String publisher;
	private String edition;

	private String publicationYear;
	private int stockQuantity;
	private int minimumThreshold;
	private double buyingPrice;
	private double sellingPrice;
	
	public BookDto(){
		
	}

	/**
	 * @param category
	 * @param authors
	 * @param title
	 * @param publisher
	 * @param edition
	 * @param publicationYear
	 * @param stockQuantity
	 * @param minimumThreshold
	 * @param buyingPrice
	 * @param sellingPrice
	 */
	public BookDto(String category, String authors, String title, String publisher, String edition,
			String publicationYear, int stockQuantity, int minimumThreshold, double buyingPrice, double sellingPrice) {
		super();
		this.category = category;
		this.authors = authors;
		this.title = title;
		this.publisher = publisher;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.stockQuantity = stockQuantity;
		this.minimumThreshold = minimumThreshold;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
	}

	public BookDto(Book book) {
		super();
		this.category = book.getCategory();
		this.authors = book.getAuthors();
		this.title = book.getTitle();
		this.publisher = book.getPublisher();
		this.edition = book.getEdition();
		this.publicationYear = book.getPublicationYear();
		this.stockQuantity = book.getStockQuantity();
		this.minimumThreshold = book.getMinimumThreshold();
		this.buyingPrice =  book.getBuyingPrice();
		this.sellingPrice = book.getSellingPrice();
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getMinimumThreshold() {
		return minimumThreshold;
	}

	public void setMinimumThreshold(int minimumThreshold) {
		this.minimumThreshold = minimumThreshold;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public long getBookID() {
		return bookID;
	}

	public void setBookID(long bookID) {
		this.bookID = bookID;
	}


	
	
	

}
