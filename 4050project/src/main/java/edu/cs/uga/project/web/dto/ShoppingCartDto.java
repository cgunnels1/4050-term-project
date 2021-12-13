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

import edu.cs.uga.project.model.Customer;


public class ShoppingCartDto {
	
	private Long customerID;
	
	private Long shoppingCartID;
	
	private Long bookID;

	private int quantity;
	
	
	public ShoppingCartDto(){
		
	}
	

	/**
	 * @param customerID
	 * @param bookID
	 * @param quantity
	 */
	public ShoppingCartDto(Long customerID, Long bookID, int quantity) {
		super();
		this.customerID = customerID;
		this.bookID = bookID;
		this.quantity = quantity;
	}




	public Long getShoppingCartID() {
		return shoppingCartID;
	}


	public void setShoppingCartID(Long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}


	public Long getBookID() {
		return bookID;
	}


	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Long getCustomerID() {
		return customerID;
	}


	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	
	
	
}
