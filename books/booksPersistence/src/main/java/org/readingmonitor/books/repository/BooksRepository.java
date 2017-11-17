package org.readingmonitor.books.repository;

import java.util.List;

import org.readingmonitor.books.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Book,String>{
	List<Book> findByTopic(String topic);
}
