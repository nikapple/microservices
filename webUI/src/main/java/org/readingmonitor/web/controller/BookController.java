package org.readingmonitor.web.controller;

import java.util.List;

import org.readingmonitor.web.form.dto.BooksByTopicResponse;
import org.readingmonitor.web.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reading-monitor")
public class BookController {
	
	@Autowired
	protected BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@ResponseBody
	@GetMapping(value="/allBooks", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<BooksByTopicResponse> displayAllBooksByTopic(Model model){
		List<BooksByTopicResponse> bookList = bookService.getAllBooksByTopic();
		return bookList;
	}
	
}
