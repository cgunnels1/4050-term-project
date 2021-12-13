package edu.cs.uga.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.repository.BookRepository;
import edu.cs.uga.project.web.dto.BookDto;

@Service
public class BookService {

	private BookRepository bookRepository;

	/**
	 * @param bookRepository
	 */
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public Book save(BookDto bookDto) {
		Book book = new Book(bookDto);
		return bookRepository.save(book);
	}
	
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> findAll() {
		return bookRepository.findAll(); 
	}
	
	public Optional<Book> findById(long id) {
		return  bookRepository.findById(id);
	}

	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
}
