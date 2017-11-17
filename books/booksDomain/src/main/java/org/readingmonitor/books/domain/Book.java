package org.readingmonitor.books.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


import org.springframework.data.annotation.Id;
@Component
@Document(collection="books")
public class Book {

	@Id
	private String id;
	private String name;
	private String author;
	private String topic;
	
	public Book() {}
	
	public Book( String name, String author, String topic) {
		this.name = name;
		this.author = author;
		this.topic = topic;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
