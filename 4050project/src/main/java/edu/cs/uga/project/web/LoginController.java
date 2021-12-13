package edu.cs.uga.project.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.config.SecurityConfiguration;
import edu.cs.uga.project.model.Admin;
import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.service.AdminService;
import edu.cs.uga.project.service.CustomerServiceImpl;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.util.UserState;
import edu.cs.uga.project.web.dto.UserLoginDto;

@Controller
@RequestMapping("/storeLogin")
public class LoginController {

	private CustomerServiceImpl customerService;
	private UserService userService;
	private BCryptPasswordEncoder encoder;
	private SecurityConfiguration secConfig;
	private AdminService adminService;
	private HttpSession session;

	public LoginController(CustomerServiceImpl customerService, UserService userService,
			SecurityConfiguration secConfig, AdminService adminService, HttpSession session) {
		super();
		this.customerService = customerService;
		this.userService = userService;
		this.secConfig = secConfig;
		this.encoder = secConfig.passwordEncoder();
		this.adminService = adminService;
		this.session = session;
	}

	@ModelAttribute("user")
	public UserLoginDto UserLoginDto() {
		return new UserLoginDto();
	}

	@GetMapping
	public String showLoginForm() {
		adminService.initDefaultAdmin();
		return "storeLogin";
	}

	@PostMapping
	//public String attemptLogin(@ModelAttribute("user") UserLoginDto loginDto) {
	public String attemptLogin(@ModelAttribute("user") UserLoginDto loginDto, HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		// Get the User
		User user = userService.getByEmail(loginDto.getEmail());
		if (user == null) { // Null check
			return "redirect:/login?usernotfound";
			// No User found
		}

		// Check if Admin
		if (user.getPriviledge() == Priviledge.Admin) {
			Admin admin = adminService.findByEmail(loginDto.getEmail());
			if (encoder.matches(loginDto.getPassword(), admin.getPassword())) {
				//Add User Privilege to session
				request.getSession().setAttribute("activeUserPriv", 0);
				return "redirect:/admin/AdminPortal";
			}
		} else if (user.getPriviledge() == Priviledge.Customer) {
			// Check if Customer
			Customer customer = customerService.getCustomerByEmail(loginDto.getEmail());
			if (customer.getUserState() == UserState.SUSPENDED) {
				return "redirect:storeLogin?suspended";
			} else if (encoder.matches(loginDto.getPassword(), customer.getPassword())) {
				request.getSession().setAttribute("activeUserPriv", 1);
				return "redirect:/customerProfile";
				//Successful login
			}
		}
		return "redirect:storeLogin?error";
		//Incorrect password
	}

}
