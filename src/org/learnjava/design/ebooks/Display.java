package org.learnjava.design.ebooks;

/**
 * Displays the active book and the user.
 * 
 * @author psajja
 *
 */
public class Display {
	private Book activeBook;
	private User activeUser;
	protected int pageNumber = 0;

	public Display(Book book, User user) {
		this.activeBook = book;
		this.activeUser = user;
	}

	public void setActiveUser(User user) {
		activeUser = user;
		refreshUser();
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveBook(Book book) {
		pageNumber = 0;
		activeBook = book;
		refreshPage();
	}

	public Book getActiveBook() {
		return activeBook;
	}

	private void refreshUser() {
		System.out.println(activeUser);
	}

	private void refreshTitle() {
		System.out.println(activeBook.getName());
	}

	private void refreshPage() {
		refreshTitle();
		System.out.println(activeBook.getPageContents(pageNumber));
	}

	public void turnPageForward() {
		if (pageNumber < activeBook.getPageSize())
			pageNumber++;
		refreshPage();
	}

	public void turnPageBackward() {
		if (pageNumber > 1)
			pageNumber--;
		refreshPage();
	}
}