package edu.cs.uga.project.web;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.UserDto;

@Controller
@RequestMapping("/registration")
public class CustomerRegistrationController {

	
	private CustomerServiceImpl customerService;
	private UserService userService;
	
	public CustomerRegistrationController(CustomerServiceImpl customerService, UserService userService) {
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
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		try{
			//Register User in the DB and send confirmation email
			customerService.loadUserByUsername(registrationDto.getEmail());
		} catch (UsernameNotFoundException ex) {
			UserDto userDto = new UserDto(registrationDto.getEmail(), Priviledge.Customer);
			userService.save(userDto);
			Customer customer = customerService.save(registrationDto);
			
			customerService.confirmationEmail(customer.getEmail());
			
			return "redirect:/registration?success";
		}
		return "redirect:/registration?error";
		
		
	}
}
