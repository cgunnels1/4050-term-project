package edu.cs.uga.project.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.service.BookService;

@ComponentScan
@Controller
public class MainController {
	
	BookService bookService;
	HttpSession session;
	
	/**
	 * @param bookService
	 */
	public MainController(BookService bookService, HttpSession session) {
		super();
		this.bookService = bookService;
		this.session = session;
	}
	

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
				
		return "index";
	}
	
}
