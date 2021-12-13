package edu.cs.uga.project.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Admin;
import edu.cs.uga.project.model.Employee;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.service.AdminService;
import edu.cs.uga.project.service.EmployeeService;
import edu.cs.uga.project.service.UserService;
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
//import edu.cs.uga.project.service.UserService;
//import edu.cs.uga.project.util.UserState;
//import edu.cs.uga.project.web.dto.UserDto;

	
@ComponentScan
@Controller
@RequestMapping("admin/promoteEmployee")
public class PromoteEmployeeController {
	
	//private UserRepository userRepository;
	private EmployeeService employeeService;
	private UserService userService;
	private AdminService adminService;
	
	public PromoteEmployeeController(EmployeeService employeeService, UserService userService, AdminService adminService) {
		super();
		this.employeeService = employeeService;
		this.userService = userService;
		this.adminService = adminService;
	}
	
	@ModelAttribute("user")
    public CustomerRegistrationDto customerRegistrationDto() {
        return new CustomerRegistrationDto();
    }
	
	@GetMapping
	public String showPage() {
		return "admin/promoteEmployee";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		Employee employee = employeeService.findByEmail(registrationDto.getEmail());
		if(employee == null) {
			return "redirect:/admin/promoteEmployee?error";
		}
		
		//change user priviledges
		User user = userService.getByEmail(employee.getEmail());
		user.setPriviledge(Priviledge.Admin);
		
		//add to admin table
		Admin admin = new Admin(employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getPassword());
		adminService.save(admin);
		
		
		//delete from employee table
		employeeService.delete(employee.getEmail());
		System.out.println("Employee Promoted to Admin");
		return "redirect:/admin/promoteEmployee?success";
	}
}