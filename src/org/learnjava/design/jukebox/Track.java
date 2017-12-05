package org.learnjava.design.jukebox;

import java.util.List;

/**
 * Represents a track.
 * 
 * @author psajja
 *
 */
public class Track {
	private final String title;
	private final List<Singer> singers;
	private final List<Lyricist> lyricists;
	
	public Track(String title, List<Singer> singers, List<Lyricist> lyricists) {
		this.title = title;
		this.singers = singers;
		this.lyricists = lyricists;
	}

	@Override
	public String toString() {
		return title;
	}

	public void play() {
		System.out.println("Playing " + title);
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public List<Lyricist> getLyricists() {
		return lyricists;
	}
}
