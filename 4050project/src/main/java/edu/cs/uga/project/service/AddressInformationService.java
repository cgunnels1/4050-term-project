package edu.cs.uga.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.AddressInformation;
import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.repository.AddressInformationRepository;
import edu.cs.uga.project.repository.CardInformationRepository;
import edu.cs.uga.project.repository.CustomerRepository;
import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.web.dto.AddressInformationDto;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.UserDto;

@Service
public class AddressInformationService{
	
	private AddressInformationRepository addressRepository;
	

	/**
	 * @param userRepository
	 */
	public AddressInformationService(AddressInformationRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	public AddressInformation save(AddressInformationDto addressDto) {
		AddressInformation address = new AddressInformation(addressDto.getStreetAddress(), addressDto.getCity(), addressDto.getState()
				,addressDto.getZipcode(), addressDto.getCustomer());
		return addressRepository.save(address);
	}

}
