package com.example.domain;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 2801095689667475734L;
	private int id;
	private String title;
	private String isbn;

	public Book() {

	}

	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		final Book book = (Book) obj;
		if (id == 0)
			return false;
		if (title != null ? !title.equals(book.title) : book.title != null)
			return false;
		if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 29 * result + (title != null ? title.hashCode() : 0);
		result = 29 * result + (isbn != null ? isbn.hashCode() : 0);
		return result;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+",title:"+title+",isbn:"+isbn;
	}
}
