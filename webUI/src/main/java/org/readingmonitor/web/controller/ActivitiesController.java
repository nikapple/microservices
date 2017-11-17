package org.readingmonitor.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.readingmonitor.web.form.dto.Activities;
import org.readingmonitor.web.form.dto.Activity;
import org.readingmonitor.web.model.User;
import org.readingmonitor.web.services.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reading-monitor")
public class ActivitiesController {
	
	@Autowired
	protected ActivitiesService activitiesService;

	public ActivitiesController(ActivitiesService activitiesService) {
		this.activitiesService = activitiesService;
	}
	
	@ResponseBody
	@GetMapping(value = "/addActivity")
	public String addActivity(@RequestParam String bookId, Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		int id = activitiesService.updateActivitiy( new Activity() {{
			setUserId(user.getId());
			setBookId(bookId);
			setReadingDate(new Date());
		}});
		return (id >= 0) ? "true" : "false";
	}

	
	@ResponseBody
	@GetMapping(value = "/getActivities")
	public List<Activity> getActivitiesByUser(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate, Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		System.out.println(startDate+" "+endDate+" "+user.getEmail());
		Activities activities =  activitiesService.getActivities(user.getId());
		return null;
	}
}
