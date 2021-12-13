package edu.cs.uga.project.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.service.BookService;
import edu.cs.uga.project.service.ShoppingCartService;
import edu.cs.uga.project.web.dto.BookDto;
import edu.cs.uga.project.web.dto.ShoppingCartDto;

@Controller
@RequestMapping("/viewBooks")
public class ViewBooksController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ShoppingCartService cartService;

//	@ModelAttribute("book")
//    public BookDto bookDto() {
//        return new BookDto();
//    }

	@GetMapping(path = "viewBook/{id}")
	public String viewBook(@PathVariable String id, Model model) {
		Optional<Book> bookOpt = bookService.findById(Long.parseLong(id));

		if (!bookOpt.isPresent()) {
			return "?error";
		}

		BookDto bookDto = new BookDto(bookOpt.get());
		bookDto.setBookID(bookOpt.get().getBookID());
		model.addAttribute("bookDto", bookDto);

		System.out.println("The book id provided was : " + id);
		return "viewBook";

	}


	@GetMapping()
	public String viewBooks(Model model) {
		Optional<Book> bookOpt = bookService.findById(7);

		if (!bookOpt.isPresent()) {
			return "?error";
		}

		BookDto bookDto = new BookDto(bookOpt.get());
		model.addAttribute("bookDto", bookDto);

		return "viewBooks";
	}

	@PostMapping(path = "/{id}")
	public String addToCart(@PathVariable String id) {
		Optional<Book> bookOpt = bookService.findById(Long.parseLong(id));

		if (!bookOpt.isPresent()) {
			return "?error";
		}
		
		long customerId = 3;
		ShoppingCartDto cartDto = new ShoppingCartDto(customerId ,Long.parseLong(id),1);
		cartService.save(cartDto);

		System.out.println("Adding book to cart; ID: " + id);

		return "redirect:?success";
	}

}
