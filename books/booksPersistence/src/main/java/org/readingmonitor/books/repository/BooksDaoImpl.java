package org.readingmonitor.books.repository;

import java.util.List;

import org.readingmonitor.books.domain.Book;
import org.readingmonitor.books.dto.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDaoImpl implements BooksDao {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Topic> getAllBooksByTopic() {
		Aggregation aggregation = newAggregation(group("topic").push("$$ROOT").as("books"));
		AggregationResults<Topic> groupResults = mongoTemplate.aggregate(aggregation, Book.class, Topic.class);
		
		List<Topic> result = groupResults.getMappedResults();
		return result;

	}

}
