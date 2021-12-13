package edu.cs.uga.project.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.Role;
import edu.cs.uga.project.repository.CustomerRepository;
import edu.cs.uga.project.util.UserState;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer save(CustomerRegistrationDto registrationDto) {

		Customer customer = new Customer(registrationDto.getFirstName(), registrationDto.getLastName(),
				registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()));
		return customerRepository.save(customer);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer customer = customerRepository.findByEmail(username);
		if (customer == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(),
				mapRolesToAuthorities(customer.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	public Customer getCustomerByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email);
		return customer;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void suspendCustomer(Customer customer) {
		customer.setUserState(UserState.SUSPENDED);
	}

	public void activateCustomer(Customer customer) {
		customer.setUserState(UserState.ACTIVE);
	}
	
	
//	public Customer findByUserId(Long userID) {
//		Optional<Customer> customer = customerRepository.findById(userID);
//		if(customer.isPresent()){
//			return customer.get();
//		} else { 
//			return null;
//		}
//	}
	

	public void confirmationEmail(String email) {
		char[] CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };

		Random random = new Random();

		char[] code = new char[5];
		for (int i = 0; i < 5; i++) {
			code[i] = CHARS[random.nextInt(CHARS.length)];
		}
		String verCode = String.valueOf(code);
		// setVerifyCode(verCode);
		String to = email;
		String from = "sdklssdlnf@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		// return new PasswordAuthentication(from, passW);
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, "badPassword");

			}

		});

		session.setDebug(true);

		try {

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("Verification Code");

			message.setText("Verification Code: " + verCode);

			System.out.println("sending...");

			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public void retrievePasswordEmail(String email, String password) {
		String to = email;
		String from = email;
		String host = "smtp.gmail.com";

		final String username = "sdklssdlnf@gmail.com";
		final String passW = password;
		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, "badPassword");

			}

		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Retrieve Password");
			message.setText("Password: " + password);
			System.out.println("sending...");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public void sendPromoEmail(String percent, String start, String end, String promoCode) {
		
		
		String from = "sdklssdlnf@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, "badPassword");

			}

		});

		session.setDebug(true);

		List<Customer> iter = getAllCustomers();

		for (int i = 0; i < iter.size(); i++) {
			Customer user = iter.get(i);
			String to = user.getEmail();

			try {

				MimeMessage message = new MimeMessage(session);

				message.setFrom(new InternetAddress(from));

				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				message.setSubject("Scamazon Promo");
				
				message.setText("Promo Code: " + promoCode + "\n" + "Get "+ percent + "% off any book" + "\n" + "Start Date: " + start
						+ "\n" + "End Date: " + end);

				System.out.println("sending...");

				Transport.send(message);
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}

			//System.out.println("Email sent");
		} // end for loop-iter
		System.out.println("Promo sent to all accounts");
		// ----end
	}

}
