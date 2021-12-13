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
@Table(name = "orders", uniqueConstraints = @UniqueConstraint(columnNames = "orderID"))
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderID", nullable = false)
	private long orderID;
	
	@Column(nullable = false)
	private String customerID;
	
	@Column(nullable = false)
	private String cardInformationID;
	
	@Column(nullable = false)
	private int  orderTime;
	
	private int promotionID;
	
	@Column(nullable = false)
	private double orderTotal;
	
	

	/**
	 * @param customerID
	 * @param cardInformationID
	 * @param orderTime
	 * @param promotionID
	 * @param orderTotal
	 */
	public Order(String customerID, String cardInformationID, int orderTime, int promotionID, double orderTotal) {
		super();
		this.customerID = customerID;
		this.cardInformationID = cardInformationID;
		this.orderTime = orderTime;
		this.promotionID = promotionID;
		this.orderTotal = orderTotal;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCardInformationID() {
		return cardInformationID;
	}

	public void setCardInformationID(String cardInformationID) {
		this.cardInformationID = cardInformationID;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public int getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(int promotionID) {
		this.promotionID = promotionID;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getCustomerID() {
		return customerID;
	}
	



}
