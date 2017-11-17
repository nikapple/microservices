package org.readingmonitor.web.services;

import java.util.Arrays;
import java.util.List;

import org.readingmonitor.web.form.dto.BooksByTopicResponse;
import org.readingmonitor.web.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
	@Autowired
	private RestTemplate restTemplate;
	private String serviceUrl;
	
	public BookService(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public List<Book> getAllBooks() {
		Book books[] = null;
		books =  restTemplate.getForObject(serviceUrl, Book[].class);
		if(books == null || books.length == 0 ) {
			return null;
		}
		else {
			return Arrays.asList(books);
		}
	}
	
	public List<BooksByTopicResponse> getAllBooksByTopic(){
		
		BooksByTopicResponse topicList[] =null;
		topicList = restTemplate.getForObject(serviceUrl+"topics",BooksByTopicResponse[].class);
		if(topicList == null || topicList.length == 0) {
			return null;
		}
		return Arrays.asList(topicList);
	}
	
	public Book getBookById(String id)
	{
		return restTemplate.getForObject(serviceUrl+id, Book.class);
	}
	
	public List<Book> getBooksByTopic(String topic)
	{
		Book books[] = null;
		books =  restTemplate.getForObject(serviceUrl+"topics/"+topic, Book[].class);
		if(books == null || books.length == 0 ) {
			return null;
		}
		else {
			return Arrays.asList(books);
		}
	}
	
	public void addBook(Book book)
	{
		restTemplate.postForLocation(serviceUrl, book);
	}	
}
