package org.learnjava.design.bookashow;

/**
 * @author psajja
 *
 */
public class Theatre {

	private String id;
	private int capacity;

	public Theatre(String id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	public String getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}
}
