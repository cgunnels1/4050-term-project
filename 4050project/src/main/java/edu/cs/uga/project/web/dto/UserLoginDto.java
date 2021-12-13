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


public class UserLoginDto {
	private String email;
	private String password;
	
	public UserLoginDto(){
		
	}
	
	
	/**
	 * @param email
	 * @param password
	 */
	public UserLoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	
}
