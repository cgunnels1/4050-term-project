package edu.cs.uga.project.web;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/editProfile")
public class EditProfileController {
	
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
	public String showEditProfileForm(Model model, HttpServletRequest request) {
		
		if(!((int)request.getSession().getAttribute("activeUserPriv") == 1)) {
			return "redirect:/storeLogin";
		}
		
		CustomerRegistrationDto profileInfo = new CustomerRegistrationDto();
		Customer customer = customerService.getCustomerByEmail("b@b.com");
		profileInfo.setEmail(customer.getEmail());
		profileInfo.setFirstName(customer.getFirstName());
		profileInfo.setLastName(customer.getLastName());
		
		
		
		model.addAttribute("profileInfo", profileInfo);
		return "editProfile";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		
		Customer user = customerService.getCustomerByEmail(registrationDto.getEmail());
		
	
		System.out.println(registrationDto.getFirstName());
		if(!(registrationDto.getFirstName()).equals("")) {
			System.out.println("Here");
			user.setFirstName(registrationDto.getFirstName());
		}
		if((registrationDto.getLastName())!=null) {
			user.setLastName(registrationDto.getLastName());
		}
		if((registrationDto.getPassword())!=null) {
			user.setPassword(registrationDto.getPassword());
		}

		
		customerService.save(user);

	
		
		return "redirect:/index";
	}
}
