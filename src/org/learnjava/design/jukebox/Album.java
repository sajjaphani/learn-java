package org.learnjava.design.jukebox;

import java.util.ArrayList;
import java.util.List;

/**
 * An album contains a list of tracks. The album can consists of a single movie
 * tracks, an album, etc.
 * 
 * @author psajja
 *
 */
public final class Album {
	private final String title;
	private final List<Track> tracks;

	public Album(String title, List<Track> tracks) {
		this.title = title;
		this.tracks = tracks;
	}

	/**
	 * Get the tracks in this album.
	 * 
	 * @return
	 * 		the tracks
	 */
	public List<Track> getTracks() {
		return new ArrayList<>(tracks);
	}

	/**
	 * Get the album title.
	 * 
	 * @return
	 * 		the title
	 */
	public String getTitle() {
		return title;
	}
}
