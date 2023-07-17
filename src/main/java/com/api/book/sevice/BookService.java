package com.api.book.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

//@Component
@Service
public class BookService {

	//private static List<Book> list=new ArrayList<>();
//	static {
//		list.add(new Book(12,"java","abc"));
//		list.add(new Book(13,"python","abcd"));
//		list.add(new Book(14,"c++","abc3"));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	public List<Book> getAllBook(){
		List<Book>list=(List<Book>)this.bookRepository.findAll(); //typecasting of iterable into list as iterable is a parent class
		return list;
	}
	//get individual book
	public Book getById(int id){
		Book book=null;
		try {
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book=this.bookRepository.findById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
	//add book
	public Book addBook(Book book) {	
		return bookRepository.save(book);
	}
	
	//delete book
	//this filter the books which are not matching while collecting and finally restore in list
	public void deleteBook(int id) {
		//list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}
	
	//update book
	public void updateBook(Book book,int id) {
//		list=list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setId(book.getId());
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		bookRepository.save(book);
	}
}
