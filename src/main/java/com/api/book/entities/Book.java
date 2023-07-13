package com.api.book.entities;

public class Book {

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
