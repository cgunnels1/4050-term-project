package edu.cs.uga.project.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import edu.cs.uga.project.web.dto.BookDto;

import javax.persistence.JoinColumn;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Entity
@Table(name = "archivedbooks", uniqueConstraints = @UniqueConstraint(columnNames = "bookID"))
public class ArchivedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookID;

	private String category;

	private String authors;
	private String title;
	private String publisher;
	private String edition;

	@Column(name = "publicationYear")
	private String publicationYear;
	@Column(name = "stockQuantity")
	private int stockQuantity;
	@Column(name = "minimumThreshold")
	private int minimumThreshold;
	@Column(name = "buyingPrice")
	private double buyingPrice;
	@Column(name = "sellingPrice")
	private double sellingPrice;


	public ArchivedBook() {

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
	public ArchivedBook(String category, String authors, String title, String publisher, String edition, String publicationYear,
			int stockQuantity, int minimumThreshold, double buyingPrice, double sellingPrice) {
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
	
	public ArchivedBook(BookDto bookDto) {
		this.category = bookDto.getCategory();
		this.authors = bookDto.getAuthors();
		this.title = bookDto.getTitle();
		this.publisher = bookDto.getPublisher();
		this.edition = bookDto.getEdition();
		this.publicationYear = bookDto.getPublicationYear();
		this.stockQuantity = bookDto.getStockQuantity();
		this.minimumThreshold = bookDto.getMinimumThreshold();
		this.buyingPrice = bookDto.getBuyingPrice();
		this.sellingPrice = bookDto.getSellingPrice();
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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	

}
