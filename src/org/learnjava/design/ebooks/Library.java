package org.learnjava.design.ebooks;

import java.util.HashMap;
import java.util.Map;

/**
 * Library of books.
 * 
 * @author psajja
 *
 */
public class Library {
	private Map<String, Book> books;

	public Library() {
		books = new HashMap<>();
	}

	public void addBook(Book book) {
		books.put(book.getId(), book);
	}

	public Book remove(Book b) {
		return remove(b.getId());
	}

	public Book remove(String id) {
		return books.remove(id);
	}

	public Book find(String id) {
		return books.get(id);
	}
}
