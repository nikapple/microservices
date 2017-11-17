package org.readingmonitor.books.dto;

import java.util.List;

import org.readingmonitor.books.domain.Book;

public class Topic {
	private String id;
	private List<Book> books;
	public String getTopic() {
		return id;
	}
	public void setTopic(String topic) {
		this.id = topic;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
