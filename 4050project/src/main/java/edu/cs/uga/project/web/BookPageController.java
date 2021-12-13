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
import edu.cs.uga.project.service.ArchivedBookService;
import edu.cs.uga.project.service.BookPageService;
import edu.cs.uga.project.service.BookService;
import edu.cs.uga.project.web.dto.BookDto;


	
@ComponentScan
@Controller
@RequestMapping("bookPage")
public class BookPageController {
	
	BookPageService bookPageService;
	BookService bookService;
	ArchivedBookService archivedBookService;
	
		
	/**
	 * @param bookService
	 */
	public BookPageController(BookService bookService, ArchivedBookService archivedBookService) {
		super();
		this.bookService = bookService;
		this.archivedBookService = archivedBookService;
	}

	@ModelAttribute("book")
    public BookDto bookDto() {
        return new BookDto();
    }
	
	@GetMapping
	public String showBookPage(Model model) {
		
		List<Book> bookList = bookService.findAll();		
		model.addAttribute("bookList", bookList);
		//List<Book> book = bookPageService.findAll();
		//model.addAttribute("book Info", book);
		

		return "bookPage";
	}
	
	@PostMapping
	public String addBookToCart(@ModelAttribute("book") BookDto bookDto) {
		return "redirect:/shoppingCart";
	}
}