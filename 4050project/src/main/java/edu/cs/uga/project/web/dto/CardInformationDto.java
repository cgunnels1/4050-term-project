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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.cs.uga.project.model.Customer;


public class CardInformationDto {
	private int cardNumber;
	private String cardType;
	private String expirationDate;
	private String cardName;
	private Customer customer;
	
	public CardInformationDto(){
		
	}

	/**
	 * @param cardNumber
	 * @param cardType
	 * @param expirationDate
	 * @param cardName
	 * @param customer
	 */
	public CardInformationDto(int cardNumber, String cardType, String expirationDate, String cardName,
			Customer customer) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expirationDate = expirationDate;
		this.cardName = cardName;
		this.customer = customer;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
}
