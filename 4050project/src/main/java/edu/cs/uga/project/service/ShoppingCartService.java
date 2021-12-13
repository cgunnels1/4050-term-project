package edu.cs.uga.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.model.ShoppingCart;
import edu.cs.uga.project.repository.ShoppingCartRepository;
import edu.cs.uga.project.web.dto.ShoppingCartDto;

@Service
public class ShoppingCartService{
	
	private ShoppingCartRepository shoppingCartRepository;
	BookService bookService;

	/**
	 * @param userRepository
	 */
	public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
		super();
		this.shoppingCartRepository = shoppingCartRepository;
		this.bookService = bookService;
	}

	public ShoppingCart save(ShoppingCartDto shoppingCartDto) {
		ShoppingCart shoppingCart = new ShoppingCart(shoppingCartDto);
		return shoppingCartRepository.save(shoppingCart);
	}
	
	public List<ShoppingCart> findAll() {
		return shoppingCartRepository.findAll(); 
	}
	public Optional<ShoppingCart> findById(long id) {
		return  shoppingCartRepository.findById(id);
	}
}