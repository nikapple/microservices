package org.readingmonitor.activities.repository;

import org.readingmonitor.activities.domain.Activity;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;

public class ActivitiesReaderConverter implements Converter<DBObject,Activity>{

	@Override
	public Activity convert(DBObject arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
