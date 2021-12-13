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
@RequestMapping("admin/demoteAdmin")
public class DemoteAdminController {
	
	//private UserRepository userRepository;
	private EmployeeService employeeService;
	private UserService userService;
	private AdminService adminService;
	
	public DemoteAdminController(EmployeeService employeeService, UserService userService, AdminService adminService) {
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
		return "admin/demoteAdmin";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") CustomerRegistrationDto registrationDto) {
		Admin admin = adminService.findByEmail(registrationDto.getEmail());
		if(admin == null) {
			return "redirect:/admin/demoteAdmin?error";
		}
		
		//change user priviledges
		User user = userService.getByEmail(admin.getEmail());
		user.setPriviledge(Priviledge.Employee);
		
		//add to employee table
		Employee employee = new Employee(admin.getFirstName(),admin.getLastName(),admin.getEmail(),admin.getPassword());
		employeeService.save(employee);
		
		
		//delete from admin table
		adminService.delete(admin.getEmail());
		System.out.println("Admin demoted to Employee");
		return "redirect:/admin/demoteAdmin?success";
	}
}