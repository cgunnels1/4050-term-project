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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "cardinformation", uniqueConstraints = @UniqueConstraint(columnNames = "cardInformationID"))
public class CardInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardInformationID", nullable = false)
	private int addressInformationID;
	
	@Column(nullable = false)
	private int cardNumber;

	@Column(nullable = false)
	private String cardType;
	@Column(nullable = false)
	private String expirationDate;
	@Column(nullable = false)
	private String cardName;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userID", nullable = false)
	private Customer customer;

	public CardInformation() {

	}

	/**
	 * @param cardNumber
	 * @param cardType
	 * @param expirationDate
	 * @param cardName
	 * @param customer
	 */
	public CardInformation(int cardNumber, String cardType, String expirationDate, String cardName, Customer customer) {
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

	public int getAddressInformationID() {
		return addressInformationID;
	}

	

}
