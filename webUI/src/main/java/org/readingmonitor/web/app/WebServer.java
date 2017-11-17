package org.readingmonitor.web.app;

import java.util.Arrays;

import org.readingmonitor.web.services.ActivitiesService;
import org.readingmonitor.web.services.BookService;
import org.readingmonitor.web.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"org.readingmonitor.web"})
public class WebServer {

	public static final String BOOK_SERVICE_URL = "http://localhost:8080/books/";
	public static final String USER_SERVICE_URL = "http://localhost:8090/users/";
	public static final String ACTIVITY_SERVICE_URL = "http://localhost:8029/activities/";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebServer.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public BookService bookService() {
		return new BookService(BOOK_SERVICE_URL);
	}

	@Bean
	public UserService userService() {
		return new UserService(USER_SERVICE_URL);
	}
	
	@Bean
	public ActivitiesService activityService() {
		return new ActivitiesService(ACTIVITY_SERVICE_URL);
	}
}
