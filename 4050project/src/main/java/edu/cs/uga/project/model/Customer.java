package edu.cs.uga.project.model;

import java.util.ArrayList;
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

import edu.cs.uga.project.util.UserState;

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
@Table(name =  "customers", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Customer{
	
//	@Id
//	@Column(name = "userID")
//	private Long userID;
	
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	private String email;
	
	private String password;
	
	private String retrievalPassword;
	
	private UserState userState;
	
	boolean isSubscribed;
	
	private String phoneNumber;
	
	private String verifyCode;
	
	private String billingAddress;
	
	private String cardType;
	
	private String cardNumber;
	
	private String expirationDate;
	
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "users",
//			joinColumns = @JoinColumn(
//		            name = "user_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(
//				            name = "role_id", referencedColumnName = "id"))
	
//	private Collection<Role> roles;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userState = UserState.INACTIVE;
		isSubscribed = true;
		//this.roles = roles;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public Collection<Role> getRoles(){
		return new ArrayList<Role>();
	}

	public UserState getUserState() {
		return userState;
	}

	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getRetrievalPassword() {
		return retrievalPassword;
	}

	public void setRetrievalPassword(String retrievalPassword) {
		this.retrievalPassword = retrievalPassword;
	}
	

	
}
