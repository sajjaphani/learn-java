package org.learnjava.design.filesystem;

/**
 * Represents a file in a file system.
 * 
 * @author psajja
 *
 */
public class File extends Entry {
	private String content;
	private int size;

	public File(String name, Directory parent) {
		super(name, parent);
	}

	public int size() {
		return size;
	}

	public String getContents() {
		return content;
	}

	public void setContents(String content) {
		this.content = content;
		this.size = content.length();
	}
}
