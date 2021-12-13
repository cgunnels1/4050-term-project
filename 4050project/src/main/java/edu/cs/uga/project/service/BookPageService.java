package edu.cs.uga.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.repository.BookPageRepository;
import edu.cs.uga.project.repository.BookRepository;
import edu.cs.uga.project.web.dto.BookDto;

@Service
public class BookPageService {
	private BookPageRepository bookPageRepository;
	private BookRepository bookRepository;

	/**
	 * @param bookRepository
	 */
	public BookPageService(BookRepository bookRepository, BookPageRepository bookPageRepository) {
		super();
		this.bookRepository = bookRepository;
		this.bookPageRepository = bookPageRepository;
	}

	public Book save(BookDto bookDto) {
		Book book = new Book(bookDto);
		return bookPageRepository.save(book);
	}
	
	
	public Book save(Book book) {
		return bookPageRepository.save(book);
	}
	
	public List<Book> findAll() {
		return bookPageRepository.findAll(); 
	}
	
	public Optional<Book> findById(long id) {
		return  bookPageRepository.findById(id);
	}

	public void delete(Book book) {
		bookPageRepository.delete(book);
	}
	
}
