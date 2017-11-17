package org.readingmonitor.web.controller;

import javax.servlet.http.HttpSession;

import org.readingmonitor.web.model.User;
import org.readingmonitor.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reading-monitor")
public class UserController {
	
	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//display registration form
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	//display user home page
	@GetMapping("/userHome/{username}")
	public String userHome(@PathVariable String username, Model model,
			HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user != null && username.equals(user.getUsername())) {
			return "userHome";
		}
		return "error";
	}
}
