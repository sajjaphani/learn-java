package org.learnjava.design.filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in a file system.
 * 
 * @author psajja
 *
 */
public class Directory extends Entry {

	protected List<Entry> entries;

	public Directory(String name, Directory parent) {
		super(name, parent);
		entries = new ArrayList<Entry>();
	}

	protected List<Entry> getEntries() {
		return entries;
	}

	public int size() {
		int size = 0;
		for (Entry entry : entries) {
			size += entry.size();
		}

		return size;
	}

	public boolean delete(Entry entry) {
		return entries.remove(entry);
	}

	public void addEntry(Entry entry) {
		entries.add(entry);
	}

}
