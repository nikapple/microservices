package org.readingmonitor.activities.repository;

import org.readingmonitor.activities.domain.Activities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivitiesRepository extends MongoRepository<Activities,String>{

}
