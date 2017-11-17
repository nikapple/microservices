package org.readingmonitor.users.repository;

import java.util.ArrayList;

import org.readingmonitor.users.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner{

	private UserRepository userRepository;
	
	public DbSeeder(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		this.userRepository.deleteAll();
		
		User nikhil = new User("nikipen", "abc@xyz.com", "Nikh", "Pere", "1234567890", "pass");
		User tom = new User("tomipen", "tom@xyz.com", "Tikh", "Mere", "1236547890", "pass");
		User jerry = new User("jerry", "jerry@xyz.com", "Jerkh", "Yere", "2134567890", "pass");
		
		this.userRepository.save(new ArrayList<User>() {
			private static final long serialVersionUID = 1L;
		{
			add(nikhil);
			add(tom);
			add(jerry);

		}});
	}

}
