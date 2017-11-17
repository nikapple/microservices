package org.readingmonitor.activities.service;

import java.util.Date;

import org.readingmonitor.activities.domain.Activities;
import org.readingmonitor.activities.domain.Activity;
import org.readingmonitor.activities.repository.ActivitiesDao;
import org.readingmonitor.activities.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivitiesContoller {
	@Autowired
	private ActivitiesDao activityDao;
	private ActivitiesRepository activitiesRepository;
	
	public ActivitiesContoller(ActivitiesRepository activitiesRepository) {
		super();
		this.activitiesRepository = activitiesRepository;
	}

	@PostMapping
	public Activities updateActivitiy(@RequestBody Activity activity)
	{
		return activityDao.update(activity);
	}
	
	@GetMapping("/{userId}")
	public Activities getActivities(@PathVariable String userId) {
		
		return activitiesRepository.findOne(userId);
	}
	
	@GetMapping("/{userId}/date-range")
	public Activities getActivitiesInDateRange(@PathVariable String userId, @RequestParam Date startDate, @RequestParam Date endDate) {
		return activityDao.getActivities(userId,startDate,endDate);
	}
	
}
