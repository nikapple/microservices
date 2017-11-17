package org.readingmonitor.activities.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Book {
	@Id
	String id;
	@Field("readingHistory")
	List<Date> readingHistory;
	
	public Book(String id) {
		this.id = id;
		this.readingHistory = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Date> getReadingHistory() {
		return readingHistory;
	}

	public void setReadingHistory(List<Date> readingHistory) {
		this.readingHistory = readingHistory;
	}
	
	
}
