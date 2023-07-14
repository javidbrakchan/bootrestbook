package com.api.book.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   public ResponseEntity<List<Book>> getBooks() {	
	  List<Book>list=bookService.getAllBook();
	  if(list.size()<=0) {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	  }
	  return ResponseEntity.of(Optional.of(list));
}
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id) {
		Book book=bookService.getById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 return ResponseEntity.of(Optional.of(book));
	}
	//creation of book
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book){   //requestbody converst input jason data into obj
		Book b=null;
		try {
			b=bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id")int id) {
		
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//update book
	@PutMapping("/books/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody Book book,@PathVariable("id")int id) {
		try {
			bookService.updateBook(book, id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
