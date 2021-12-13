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

import edu.cs.uga.project.model.Customer;


public class AddressInformationDto {
	private String city;
	private String state;
	private String streetAddress;
	private int zipcode;
	private Customer customer;
	
	public AddressInformationDto(){
		
	}

	/**
	 * @param city
	 * @param state
	 * @param streetAddress
	 * @param zipcode
	 * @param customer
	 */
	public AddressInformationDto(String city, String state, String streetAddress, int zipcode, Customer customer) {
		super();
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipcode = zipcode;
		this.customer = customer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
