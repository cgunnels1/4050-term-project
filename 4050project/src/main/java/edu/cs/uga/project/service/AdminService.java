package edu.cs.uga.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Admin;
import edu.cs.uga.project.model.Employee;
import edu.cs.uga.project.repository.AdminRepository;
import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.util.Priviledge;
import edu.cs.uga.project.web.dto.AdminDto;
import edu.cs.uga.project.web.dto.UserDto;

@Service
public class AdminService{
	
	private AdminRepository adminRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	/**
	 * @param userRepository
	 */
	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	public Admin save(AdminDto adminDto) {
		Admin admin = new Admin(adminDto.getFirstName(), adminDto.getLastName(), 
				adminDto.getEmail(), passwordEncoder.encode(adminDto.getPassword()));//TODO : Construct and Return Order Object based upon an OrderDto
		return adminRepository.save(admin);
	}
	
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}
	
	public void initDefaultAdmin() {
		Admin defaultAdmin = adminRepository.findByEmail("admin@bkstr.com");
		if(defaultAdmin == null) {
			
			AdminDto adminDto = new AdminDto("admin", "admin", "admin@bkstr.com", "admin");
			defaultAdmin = save(adminDto);

			UserDto userDto = new UserDto("admin@bkstr.com",Priviledge.Admin);
			userService.save(userDto);
		}
	}
	
	
	public void delete(String email) {
		Admin employee = adminRepository.findByEmail(email);
		adminRepository.delete(employee);
	}
	
}
