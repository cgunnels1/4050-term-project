package edu.cs.uga.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.CardInformation;
import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.Order;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.repository.CardInformationRepository;
import edu.cs.uga.project.repository.CustomerRepository;
import edu.cs.uga.project.repository.OrderRepository;
import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.web.dto.CardInformationDto;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.OrderDto;
import edu.cs.uga.project.web.dto.UserDto;

@Service
public class OrderService{
	
	private OrderRepository orderRepository;
	

	/**
	 * @param userRepository
	 */
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public Order save(OrderDto orderDto) {
		//Order card = new CardInformation();
		//TODO : Construct and Return Order Object based upon an OrderDto
		return null;
	}

}
