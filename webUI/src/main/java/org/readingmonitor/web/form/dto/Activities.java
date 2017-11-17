package org.readingmonitor.web.form.dto;

import java.util.Date;
import java.util.List;

public class Activities {
	
	private String userId;
	private List<Date> readingHistoryList;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Date> getReadingHistoryList() {
		return readingHistoryList;
	}
	public void setReadingHistoryList(List<Date> readingHistoryList) {
		this.readingHistoryList = readingHistoryList;
	}
	
}
