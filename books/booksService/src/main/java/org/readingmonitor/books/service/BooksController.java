package org.readingmonitor.books.service;

import java.util.List;

import org.readingmonitor.books.domain.Book;
import org.readingmonitor.books.dto.Topic;
import org.readingmonitor.books.repository.BooksDao;
import org.readingmonitor.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

	protected BooksRepository booksRepository;
	@Autowired
	private BooksDao booksDao;
	
	public BooksController(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	@GetMapping
	public List<Book> getAllBooks(){
		return booksRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable String id) {
		return booksRepository.findOne(id);
	}
	
	@GetMapping("/topics/{topic}")
	public List<Book> getBooksByTopic(@PathVariable String topic)
	{
		return booksRepository.findByTopic(topic);
	}
	
	@GetMapping("/topics")
	public List<Topic> getAllBooksByTopic()
	{
		return booksDao.getAllBooksByTopic();
	}
	
	@PostMapping
	public void addBook(@RequestBody Book book)
	{
		booksRepository.insert(book);
	}
}