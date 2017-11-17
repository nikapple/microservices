package org.readingmonitor.users.service;

import org.readingmonitor.users.domain.User;
import org.readingmonitor.users.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) {
		return userRepository.findOne(id);
	}
	
	@PostMapping("/add")
	public User addUser(User user) {
		return userRepository.insert(user);
	}

	//if user exists return user
	@PostMapping("/validate")
	public User validateUser(@RequestBody User user) {
		return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}

	@PostMapping("/exists")
	public User getUserByEmail(@RequestBody User user) {
		return userRepository.findByEmail(user.getEmail());
	}

}
