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
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.util.UserState;


public class UserDto {
	private long userID;
	private Priviledge priviledge;
	private String email;
	
	public UserDto(){
		
	}

	/**
	 * @param userState
	 */
	public UserDto(String email, Priviledge priviledge) {
		super();
		this.priviledge = priviledge;
		this.email = email;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
	
	
	
}
