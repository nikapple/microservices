package org.readingmonitor.web.services;

import org.readingmonitor.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	@Autowired
	private RestTemplate restTemplate;
	private String serviceUrl;
	
	public UserService(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public User getUserById(@PathVariable String id) {
		return restTemplate.getForObject(serviceUrl+id, User.class);
	}
	
	public User addUser(User user) {
		return restTemplate.postForObject(serviceUrl+"add", user,User.class);
	}

	public User validateUser(User user) {
		return restTemplate.postForObject(serviceUrl+"validate", user,User.class);
	}

	public User getUserByEmail(User user) {
		return restTemplate.postForObject(serviceUrl+"exists", user,User.class);
	}
}
