package edu.cs.uga.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.CardInformation;
import edu.cs.uga.project.model.Customer;
import edu.cs.uga.project.model.User;
import edu.cs.uga.project.repository.CardInformationRepository;
import edu.cs.uga.project.repository.CustomerRepository;
import edu.cs.uga.project.repository.UserRepository;
import edu.cs.uga.project.web.dto.CardInformationDto;
import edu.cs.uga.project.web.dto.CustomerRegistrationDto;
import edu.cs.uga.project.web.dto.UserDto;

@Service
public class CardInformationService{
	
	private CardInformationRepository cardRepository;
	

	/**
	 * @param userRepository
	 */
	public CardInformationService(CardInformationRepository cardRepository) {
		super();
		this.cardRepository = cardRepository;
	}

	public CardInformation save(CardInformationDto cardDto) {
		CardInformation card = new CardInformation(cardDto.getCardNumber(), cardDto.getCardType(), cardDto.getExpirationDate(), cardDto.getCardName(), cardDto.getCustomer());
		return cardRepository.save(card);
	}

}
