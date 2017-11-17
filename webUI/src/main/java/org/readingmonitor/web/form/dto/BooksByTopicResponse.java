package org.readingmonitor.web.form.dto;

import java.util.List;

import org.readingmonitor.web.model.Book;

public class BooksByTopicResponse {

	private String topic;
	private List<Book> books;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	

	
}
