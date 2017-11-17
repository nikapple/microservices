package org.readingmonitor.activities.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document(collection="activities")
public class Activity {
	
	@Id
	private String userId;
	private String bookId;
	private Date readingDate;
	
	public Activity() {}
	
	public Activity(String userId, String bookId, Date readingDate) {
		this.userId = userId;
		this.bookId = bookId;
		this.readingDate = readingDate;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
