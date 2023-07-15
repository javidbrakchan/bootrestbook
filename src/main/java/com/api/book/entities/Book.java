package com.api.book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="Books")
public class Book {

	
@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="book_id")
private int Id;
private String title;
private String author;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public Book(int id, String title, String author) {
	super();
	Id = id;
	this.title = title;
	this.author = author;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Book [Id=" + Id + ", title=" + title + ", author=" + author + "]";
}

}
