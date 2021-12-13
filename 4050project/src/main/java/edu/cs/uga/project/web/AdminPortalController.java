package edu.cs.uga.project.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;

@Controller
@RequestMapping("admin/AdminPortal")
public class AdminPortalController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
    public CustomerRegistrationDto userRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping()
	public String showAdminPortal(HttpServletRequest request) {
		 System.out.println(request.getSession().getAttribute("activeUserPriv"));
		if((int)request.getSession().getAttribute("activeUserPriv") == 0) {
			//Check User Privs
			return "admin/AdminPortal";	
		} else {
			return "redirect:/";
		}
		
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto emailDto) {
			return "admin/AdminPortal";
	}
	
	
	@RequestMapping(value="/admin/AdminPortal", method=RequestMethod.GET, params="action=hold")
	public String holdMyPost() {
		
		System.out.println("ALERT!!!!! >>> We caught the POST");
		return "redirect:AdminPortal?id=13259128501925";
	}
	
	
	@GetMapping(path="/{id}")
	public String testing(@PathVariable String id) {
		
		System.out.println("The id provided was : " + id );
		return "redirect:/admin/AdminPortal";
	}
	
	
}
