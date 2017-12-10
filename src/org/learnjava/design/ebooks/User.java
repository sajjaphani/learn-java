package org.learnjava.design.ebooks;

/**
 * Represents a system user.
 * 
 * @author psajja
 *
 */
public class User {
	private String userId;
	private String name;

	private Account account;

	public User(String userId, String name, Account account) {
		this.userId = userId;
		this.name = name;
		this.account = account;
	}

	public String getId() {
		return userId;
	}

	public void setId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}
}
