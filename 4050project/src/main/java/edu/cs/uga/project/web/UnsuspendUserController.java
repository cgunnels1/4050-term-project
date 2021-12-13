package edu.cs.uga.project.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.UserState;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
//import edu.cs.uga.project.service.UserService;
//import edu.cs.uga.project.util.UserState;
//import edu.cs.uga.project.web.dto.UserDto;

	
@ComponentScan
@Controller
@RequestMapping("admin/unsuspendUser")
public class UnsuspendUserController {
	
	//private UserRepository userRepository;
	private CustomerServiceImpl customerService;
	private UserService userService;
	
	public UnsuspendUserController(CustomerServiceImpl customerService, UserService userService) {
		super();
		this.customerService = customerService;
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public CustomerRegistrationDto customerRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping
	public String showSuspendUserForm() {
		return "admin/unsuspendUser";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		Customer customer = customerService.getCustomerByEmail(registrationDto.getEmail());
		customer.setUserState(UserState.ACTIVE);
		customerService.save(customer);
		System.out.println("User State changed to suspended");
		return "redirect:/admin/unsuspendUser?success";
	}
}