package org.learnjava.design.jukebox;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private Map<String, User> users;

	public UserManager() {
		users = new HashMap<>();
	}
	
	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	public User remove(User u) {
		return remove(u.getId());
	}

	public User remove(String id) {
		return users.remove(id);
	}

	public User find(int id) {
		return users.get(id);
	}
}
