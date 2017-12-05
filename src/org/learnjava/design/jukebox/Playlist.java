package org.learnjava.design.jukebox;

import java.util.List;

/**
 * Typically user created playlist.
 * 
 * @author psajja
 *
 */
public class Playlist {
	private String title;
	private List<Track> tracks;

	public Playlist(String title, List<Track> tracks) {
		this.title = title;
		this.tracks = tracks;
	}

	/**
	 * Add a new track to the playlist.
	 * 
	 * @param track
	 * 		given track
	 */
	public void add(Track track) {
		tracks.add(track);
	}

	public void remove(Track track) {
		this.tracks.remove(track);
	}
	
	/**
	 * Playlist title.
	 * 
	 * @return
	 * 		the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set the playlist title.
	 * 
	 * @param title
	 * 		the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Get the tracks in this playlist.
	 * 
	 * @return
	 * 		the tracks
	 */
	public List<Track> getTracks() {
		return tracks;
	}
}
