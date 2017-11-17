package org.readingmonitor.web.services;

import org.readingmonitor.web.form.dto.Activities;
import org.readingmonitor.web.form.dto.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivitiesService {
	@Autowired
	private RestTemplate restTemplate;
	private String serviceUrl;
	
	public ActivitiesService( ) {
	}
	
	public ActivitiesService(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public int updateActivitiy(Activity activity)
	{
		return restTemplate.postForObject(serviceUrl, activity, Integer.class);
	}
	
	public Activities getActivities( String userId) {
		return restTemplate.getForObject(serviceUrl, Activities.class);
	}
}
