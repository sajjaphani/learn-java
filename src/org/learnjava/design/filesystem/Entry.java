package org.learnjava.design.filesystem;

import java.io.File;

/**
 * An entry in a file system.
 * 
 * @author psajja
 *
 */
public abstract class Entry {
	private String name;

	private long dateCreated;
	private long dateModified;
	private long dateAccessed;

	protected Directory parent;

	public Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		this.dateCreated = System.currentTimeMillis();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean delete() {
		if (parent == null)
			return false;

		return parent.delete(this);
	}

	public abstract int size();

	public String getFullPath() {
		if (parent == null)
			return name;

		return parent.getFullPath() + File.separator + name;
	}

	public long getDateCreation() {
		return dateCreated;
	}

	public long getDateModified() {
		return dateModified;
	}

	public void setDateModified(long dateModified) {
		this.dateModified = dateModified;
	}
	
	public long getDateAccessed() {
		return dateAccessed;
	}
	
	public void setDateAccessed(long dateAccessed) {
		this.dateAccessed = dateAccessed;
	}

	// TODO we can have method related to accessibility
}