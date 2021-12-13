package edu.cs.uga.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private UserService userService;
	/*
	public RetrievePasswordController(UserService userService) {
		super();
		this.userService = userService;
	}*/
	
	@ModelAttribute("user")
    public CustomerRegistrationDto userRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping
	public String showEditProfileForm(Model model) {
		return "checkout";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		return "redirect:/index";
	}
}