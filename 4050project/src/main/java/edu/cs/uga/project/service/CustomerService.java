package edu.cs.uga.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;

public interface CustomerService extends UserDetailsService{
	Customer save(CustomerRegistrationDto registrationDto);
}
