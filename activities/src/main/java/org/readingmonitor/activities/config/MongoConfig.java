package org.readingmonitor.activities.config;

import java.util.ArrayList;
import java.util.List;

import org.readingmonitor.activities.repository.ActivitiesWriteConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration 
{
	 private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

	@Override
	protected String getDatabaseName() {
		return "readingMonitor";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}

	@Override
    public CustomConversions customConversions() {
     converters.add(new ActivitiesWriteConverter());
        return new CustomConversions(converters);
    }

}
