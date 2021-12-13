package edu.cs.uga.project.web;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.Employee;
import edu.cs.uga.project.service.EmployeeService;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.UserDto;

@Controller
@RequestMapping("/admin/employeeRegistration")
public class EmployeeRegistrationController {

	private EmployeeService employeeService;
	private UserService userService;

	/**
	 * @param employeeService
	 * @param userService
	 */
	public EmployeeRegistrationController(EmployeeService employeeService, UserService userService) {
		super();
		this.employeeService = employeeService;
		this.userService = userService;
	}

	@ModelAttribute("employee")
	public CustomerRegistrationDto customerRegistrationDto() {
		return new CustomerRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "/admin/employeeRegistration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("employee") CustomerRegistrationDto registrationDto) {

		Employee employee = employeeService.findByEmail(registrationDto.getEmail());
		if (employee == null) {

			UserDto userDto = new UserDto(registrationDto.getEmail(), Priviledge.Employee);
			userService.save(userDto);
			employeeService.save(registrationDto);
			return "redirect:/admin/employeeRegistration?success";

		} else {
			return "redirect:/admin/employeeRegistration?error";
		}

	}
}
