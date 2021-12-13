package edu.cs.uga.project.web;

import edu.cs.uga.project.model.User;

import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.service.CustomerService;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

	
@ComponentScan
@Controller
@RequestMapping("/customerProfile")
public class CustomerProfileCtrl {
	
	//private UserRepository userRepository;
	private CustomerServiceImpl customerService;
	private CustomerService userService;
	
	public CustomerProfileCtrl(CustomerServiceImpl customerService, CustomerService userService) {
		super();
		this.customerService = customerService;
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public CustomerRegistrationDto customerRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping
	public String showCustomerProfileForm() {
		return "customerProfile";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		return "redirect:/customerProfile";
	}
}