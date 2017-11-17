package org.readingmonitor.activities.repository;

import java.util.Date;

import org.readingmonitor.activities.domain.Activities;
import org.readingmonitor.activities.domain.Activity;
import org.readingmonitor.activities.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ActivitiesDaoImpl implements ActivitiesDao{

	@Autowired
	MongoOperations mongoOperations;
	
	@Override
	public Activities update(Activity activity) {
		
		addUserActivityDocument(activity);
		addBook(activity);
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(activity.getUserId()).and("books._id").is(activity.getBookId()));
	
		Update update = new Update().addToSet("books.$.readingHistory", activity.getReadingDate());
		Activities result = mongoOperations.findAndModify(query, update, Activities.class);
		//Activity result =  mongoOperations.findAndModify(query, new Update().addToSet("books."+activity.getBookId(), activity.getReadingDate()),Activity.class);
		//Update addBookReadingDate = new Update();
		//addBookReadingDate = addBookReadingDate.addToSet("books").each(addBookReadingDate.addToSet(activity.getBookId(), activity.getReadingDate()));
		//.push(activity.getBookId(), activity.getReadingDate());
		
		//WriteResult result = mongoOperations.upsert(query,addBookReadingDate,Activities.class);
		//add to reading dates array
		return result;
	}

	private void addBook(Activity activity) {
		if(!checkBookExists(activity)) {
			Query query = new Query();
			query.addCriteria(Criteria.where("userId").is(activity.getUserId()));
			
			//Update update = new Update().push("books").each("_id", activity.getBookId());
		//	mongoOperations.updateFirst(query, update, Activities.class);
			
			Book newBook = new Book(activity.getBookId());
			
			Activities userActivities = mongoOperations.findOne(query, Activities.class);
			userActivities.getBooks().add(newBook);
			mongoOperations.save(userActivities);
		}
	}

	private boolean checkBookExists(Activity activity) {

		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(activity.getUserId()).and("books._id").is(activity.getBookId()));
		return mongoOperations.exists(query, Activities.class);
	}

	private void addUserActivityDocument(Activity activity) {
		if(!checkUserActivitiesExists(activity)) {
			mongoOperations.insert(activity);
		}
	}
	
	private boolean checkUserActivitiesExists(Activity activity) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(activity.getUserId()));
		return mongoOperations.exists(query,Activity.class);
	}
	
	
	@Override
	public Activities getActivities(String userId, Date startDate, Date endDate) {
	
		
		// TODO Auto-generated method stub
		return null;
	}

}
