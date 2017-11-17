package org.readingmonitor.activities.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@ComponentScan(basePackages= {"org.readingmonitor"})
@EnableMongoRepositories("org.readingmonitor")
public class ActivitiesServer {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ActivitiesServer.class, args);
	}

}
