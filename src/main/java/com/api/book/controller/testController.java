package com.api.book.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.sevice.BookService;

@RestController
public class testController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
public List<Book> getBooks() {	
	 return this.bookService.getAllBook();
}
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id")int id) {
		return bookService.getById(id);
	}
}
