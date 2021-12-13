package edu.cs.uga.project.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.repository.CustomerRepository;
import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.util.Priviledge;

@Service
public class ActiveUserService{
	
	private User activeUser;
	private UserRepository userRepository;
	private CustomerRepository customerRepository;
	private String firstName;
	//private AdminRepository adminRepository
	

	/**
	 * @param userRepository
	 * @param customerRepository
	 */
	public ActiveUserService(UserRepository userRepository, CustomerRepository customerRepository) {
		super();
		//this.activeUser = activeUser;
		this.userRepository = userRepository;
		this.customerRepository = customerRepository;
		//this.firstName = getName();
	}
	
	public  Priviledge getPriviledge() {
		return activeUser.getPriviledge();
	}
	
//	public  String getName() {
//		if(getPriviledge() == Priviledge.Customer) {
//			Optional<Customer> user = customerRepository.findById(activeUser.getUserID());
//			return user.get().getFirstName();
//		} else {
//			return "";
//		}
//	}

	

}
