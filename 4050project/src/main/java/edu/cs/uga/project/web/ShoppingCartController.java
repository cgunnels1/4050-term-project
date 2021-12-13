package edu.cs.uga.project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.ArchivedBook;
import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.model.ShoppingCart;
import edu.cs.uga.project.repository.ShoppingCartRepository;
import edu.cs.uga.project.service.ArchivedBookService;
import edu.cs.uga.project.service.BookPageService;
import edu.cs.uga.project.service.BookService;
import edu.cs.uga.project.service.ShoppingCartService;
import edu.cs.uga.project.web.dto.BookDto;


	
@ComponentScan
@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
	
	private ShoppingCartRepository shoppingCartRepository;
	ShoppingCartService cartService;
	BookService bookService;
	
		
	/**
	 * @param bookService
	 */
	public ShoppingCartController(BookService bookService, ShoppingCartRepository shoppingCartRepository) {
		super();
		this.bookService = bookService;
		this.shoppingCartRepository = shoppingCartRepository;
	}

	@ModelAttribute("book")
    public BookDto bookDto() {
        return new BookDto();
    }
	
	@GetMapping
	public String showShoppingCartPage(Model model) {
		
		//Optional<ShoppingCart> cartList = cartService.findById(1);		
		//model.addAttribute("cartList", cartList);
		
		//List<Book> book = bookPageService.findAll();
		//model.addAttribute("book Info", book);
		

		return "shoppingCart";
	}
	
	@PostMapping
	public String completeOrder(@ModelAttribute("book") BookDto bookDto) {
		return "redirect:/checkout";
	}
}