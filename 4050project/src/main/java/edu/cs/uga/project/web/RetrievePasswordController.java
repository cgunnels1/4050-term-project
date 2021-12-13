package edu.cs.uga.project.web;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.service.CustomerService;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.UserState;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.UserDto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan
@Controller
@RequestMapping("/retrievePassword")
public class RetrievePasswordController {

	
	private CustomerServiceImpl customerService;
	private UserService userService;
	
	public RetrievePasswordController(CustomerServiceImpl customerService, UserService userService) {
		super();
		this.customerService = customerService;
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public CustomerRegistrationDto customerRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "retrievePassword";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		
		customerService.retrievePasswordEmail(registrationDto.getEmail(), customerService.loadUserByUsername(registrationDto.getEmail()).getPassword());
		return "redirect:/retrievePassword?success";
	}
}
