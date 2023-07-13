package com.api.book.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

@Component
public class BookService {

	private static List<Book> list=new ArrayList<>();
	static {
		list.add(new Book(12,"java","abc"));
		list.add(new Book(13,"python","abcd"));
		list.add(new Book(14,"c++","abc3"));
	}
	//get all books
	public List<Book> getAllBook(){
		return list;
	}
	//get individual book
	public Book getById(int id){
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
}
