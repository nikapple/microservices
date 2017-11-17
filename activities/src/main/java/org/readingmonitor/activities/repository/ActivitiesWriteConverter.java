package org.readingmonitor.activities.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.readingmonitor.activities.domain.Activity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Component
@WritingConverter
public class ActivitiesWriteConverter implements Converter<Activity,DBObject>{

	@Override
	public DBObject convert(Activity activity) {
		DBObject document = new BasicDBObject();
		document.put("_id",activity.getUserId());
		Document booksDocument = new Document();
		/*booksDocument.append("books", new HashMap<Map<String,String>,Map<String,List<Date>>>()
		{
			private static final long serialVersionUID = 1L;
			{
				put(activity.getBookId(), new ArrayList<Date>());
			}
		});*/
		booksDocument.append("books", new ArrayList<Document>() {
			private static final long serialVersionUID = 1L;
		{
			add(new Document() {
				private static final long serialVersionUID = 1L;

			{
					append("_id", activity.getBookId());
					append("readingHistory",new ArrayList<Date>());
			}});
		}});
		document.putAll(booksDocument);
		return document;
	}

}
