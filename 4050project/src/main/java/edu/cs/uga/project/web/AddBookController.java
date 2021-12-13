package edu.cs.uga.project.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.service.BookService;
import edu.cs.uga.project.web.dto.BookDto;


	
@ComponentScan
@Controller
@RequestMapping("admin/addBook")
public class AddBookController {
	
	
	BookService bookService;
	
	
	/**
	 * @param bookService
	 */
	public AddBookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@ModelAttribute("book")
    public BookDto bookDto() {
        return new BookDto();
    }
	
	@GetMapping
	public String showPage() {
		return "admin/addBook";
	}
	
	@PostMapping
	public String addBook(@ModelAttribute("book") BookDto bookDto) {
		Book book = new Book(bookDto);
		bookService.save(book);
		//Probably Add validation somewhere
		return "redirect:/admin/addBook?success";
	}
}