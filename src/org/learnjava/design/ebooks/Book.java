package org.learnjava.design.ebooks;

/**
 * An ebook.
 * 
 * @author psajja
 *
 */
public class Book {
	private String bookId;
	private String name;

	private String contents;

	public Book(String bookId, String name, String contents) {
		this.bookId = bookId;
		this.name = name;
		this.contents = contents;
	}

	public String getId() {
		return bookId;
	}

	public String getName() {
		return name;
	}

	public String getContents() {
		return contents;
	}

	public String getPageContents(int page) {
		return "Page " + page + " Contents";
	}

	public int getPageSize() {
		return 10;
	}
}
