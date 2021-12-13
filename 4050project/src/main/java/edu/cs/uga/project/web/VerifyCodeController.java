package edu.cs.uga.project.web;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.UserState;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
//import edu.cs.uga.project.service.UserService;
//import edu.cs.uga.project.util.UserState;
//import edu.cs.uga.project.web.dto.UserDto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


	
@ComponentScan
@Controller
@RequestMapping("/verifyCode")
public class VerifyCodeController {
	
	
	private CustomerServiceImpl customerService;
	private UserService userService;
	
	public VerifyCodeController(CustomerServiceImpl customerService, UserService userService) {
		super();
		this.customerService = customerService;
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public CustomerRegistrationDto customerRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping
	public String showVerifyCodeForm() {
		return "verifyCode";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		//get Verification Code input from user
		String vcode = registrationDto.getFirstName();
		Customer customer = customerService.getCustomerByEmail(registrationDto.getEmail());
		customer.setUserState(UserState.ACTIVE);
		customerService.save(customer);
		
		
		
		
		//customerService.save(registrationDto);
		System.out.println("User State changed to active");
		//customerService.retrievePasswordEmail(registrationDto.getEmail(), customerService.loadUserByUsername(registrationDto.getEmail()).getPassword());
		return "redirect:/verifyCode?success";
		//return "redirect:/registration?success";
	}
	
}