package edu.cs.uga.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Employee;
import edu.cs.uga.project.repository.EmployeeRepository;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.EmployeeDto;

@Service
public class EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	/**
	 * @param userRepository
	 */
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee save(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(), 
				employeeDto.getEmail(), passwordEncoder.encode(employeeDto.getPassword()));//TODO : Construct and Return Order Object based upon an OrderDto
		return employeeRepository.save(employee);
	}
	
	public Employee save(CustomerRegistrationDto registrationDto) {
		Employee employee = new Employee(registrationDto.getFirstName(), registrationDto.getLastName(), 
				registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()));//TODO : Construct and Return Order Object based upon an OrderDto
		return employeeRepository.save(employee);
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	public void delete(String email) {
		Employee employee = employeeRepository.findByEmail(email);
		employeeRepository.delete(employee);
	}
	
}
