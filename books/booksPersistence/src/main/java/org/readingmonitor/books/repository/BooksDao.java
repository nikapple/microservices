package org.readingmonitor.books.repository;

import java.util.List;

import org.readingmonitor.books.dto.Topic;

public interface BooksDao {
	List<Topic> getAllBooksByTopic();
}
