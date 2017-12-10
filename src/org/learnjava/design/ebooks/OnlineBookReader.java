package org.learnjava.design.ebooks;

/**
 * Ebook reader.
 * 
 * @author psajja
 *
 */
public class OnlineBookReader {
	private Library library;
	private UserManager userManager;
	private Display display;

	public OnlineBookReader(Library library, UserManager userManager, Display display) {
		this.library = library;
		this.userManager = userManager;
		this.display = display;
	}

	public Library getLibrary() {
		return library;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public Display getDisplay() {
		return display;
	}

	public Book getActiveBook() {
		return display.getActiveBook();
	}

	public void setActiveBook(Book book) {
		display.setActiveBook(book);
	}

	public User getActiveUser() {
		return display.getActiveUser();
	}

	public void setActiveUser(User user) {
		display.setActiveUser(user);
	}
}
