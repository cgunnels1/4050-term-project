package edu.cs.uga.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cs.uga.project.model.ArchivedBook;
import edu.cs.uga.project.model.Book;
import edu.cs.uga.project.repository.ArchivedBookRepository;
import edu.cs.uga.project.web.dto.BookDto;

@Service
public class ArchivedBookService {

	private ArchivedBookRepository bookRepository;

	/**
	 * @param bookRepository
	 */
	public ArchivedBookService(ArchivedBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public ArchivedBook save(BookDto bookDto) {
		ArchivedBook book = new ArchivedBook(bookDto);
		return bookRepository.save(book);
	}
	
	
	public ArchivedBook save(ArchivedBook book) {
		return bookRepository.save(book);
	}
	
	public List<ArchivedBook> findAll() {
		return bookRepository.findAll(); 
	}

}
