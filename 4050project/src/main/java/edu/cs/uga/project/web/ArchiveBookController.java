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
import edu.cs.uga.project.service.BookService;
import edu.cs.uga.project.web.dto.BookDto;


	
@ComponentScan
@Controller
@RequestMapping("admin/archiveBook")
public class ArchiveBookController {
	
	
	BookService bookService;
	ArchivedBookService archivedBookService;
	
		
	/**
	 * @param bookService
	 */
	public ArchiveBookController(BookService bookService, ArchivedBookService archivedBookService) {
		super();
		this.bookService = bookService;
		this.archivedBookService = archivedBookService;
	}

	@ModelAttribute("book")
    public BookDto bookDto() {
        return new BookDto();
    }
	
	@GetMapping
	public String showPage(Model model) {
		
		List<Book> bookList = bookService.findAll();
		List<ArchivedBook> archivedBookList = archivedBookService.findAll();
		model.addAttribute("bookList", bookList);
		model.addAttribute("archivedBookList", archivedBookList);

		return "admin/archiveBook";
	}
	
	@PostMapping
	public String archiveBook(@ModelAttribute("book") BookDto bookDto) {
		
		//Find Book by ID in books
		Optional<Book> optional = bookService.findById(bookDto.getBookID());
		if(!optional.isPresent()) {
			return "redirect:/admin/archiveBook?error";
		} 
		Book book = optional.get();
		
		//create ArchivedBook
		ArchivedBook aBook = new ArchivedBook(book.toDto());
		
		//Save ArchivedBook
		archivedBookService.save(aBook);
		
		//Delete Book
		bookService.delete(book);
		return "redirect:/admin/archiveBook?success";
	}
}