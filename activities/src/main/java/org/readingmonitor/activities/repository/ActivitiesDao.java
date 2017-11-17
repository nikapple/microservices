package org.readingmonitor.activities.repository;

import java.util.Date;

import org.readingmonitor.activities.domain.Activities;
import org.readingmonitor.activities.domain.Activity;

public interface ActivitiesDao {

	Activities update(Activity activity);
	Activities getActivities(String userId, Date startDate, Date endDate);
}
