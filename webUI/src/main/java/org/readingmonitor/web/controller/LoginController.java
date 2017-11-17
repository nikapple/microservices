package org.readingmonitor.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.readingmonitor.web.form.dto.LoginFormResponse;
import org.readingmonitor.web.model.User;
import org.readingmonitor.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/reading-monitor")
public class LoginController {
	
	@Autowired
	UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	//display login form
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@ResponseBody
	@PostMapping(value = "/login", produces =MediaType.APPLICATION_JSON_VALUE)
	public LoginFormResponse processLogin(@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult, Model model) {

		LoginFormResponse response = new LoginFormResponse();
		if (bindingResult.hasFieldErrors("email")
				|| bindingResult.hasFieldErrors("password")) {
			Map<String, String> errors = bindingResult
					.getFieldErrors()
					.stream()
					.collect(
							Collectors.toMap(FieldError::getField,
									FieldError::getDefaultMessage));
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else if ((user=userService.validateUser(user)) == null) 
		{
			Map<String, String> errors = new HashMap<>();
			errors.put("failedLoginMessage", "Invalid Credentials");
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else
		{
			model.addAttribute("user", user);
			response.setUserName(user.getUsername());
			response.setValidated(true);
		}
		return response;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (!session.isNew()) {
			session.invalidate();
		}
		return "redirect:login";
	}
}
