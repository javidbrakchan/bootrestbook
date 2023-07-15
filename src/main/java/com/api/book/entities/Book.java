package com.api.book.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Books")
public class Book {

	
@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="book_id")
private int Id;
private String title;
@OneToOne(cascade=CascadeType.ALL)//cascade..created author at the time of book creation because we need author id before creation of book
private Author author;
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
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}
public Book(int id, String title, Author author) {
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
