package edu.cs.uga.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.Employee;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.repository.CustomerRepository;
import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.UserDto;

@Service
public class UserService{
	
	private UserRepository userRepository;
	

	/**
	 * @param userRepository
	 */
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(),  userDto.getPriviledge());
		return userRepository.save(user);
	}

	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void delete(String email) {
		User user = userRepository.findByEmail(email);
		userRepository.delete(user);
	}
	
}
