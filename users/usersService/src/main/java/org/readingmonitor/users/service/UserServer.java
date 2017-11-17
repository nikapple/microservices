package org.readingmonitor.users.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.readingmonitor")
@ComponentScan(basePackages= {"org.readingmonitor"})
public class UserServer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserServer.class, args);
	}

}
