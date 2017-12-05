package org.learnjava.design.jukebox;

import java.util.Set;

/**
 * Jukebox, responsible to manage albums, playlists and the music player.
 * 
 * 
 * @author psajja
 *
 */
public class Jukebox {
	protected MusicPlayer player;
	protected Set<Album> albums;
	protected Set<Playlist> playlists;

	protected User user;

	public Jukebox(MusicPlayer player, Set<Album> albums, Set<Playlist> playlists, User user) {
		this.player = player;
		this.albums = albums;
		this.playlists = playlists;
		this.user = user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Add a new album
	 * 
	 * @param album
	 *            new album
	 */
	public void add(Album album) {
		albums.add(album);
	}

	/**
	 * Add a new playlist.
	 * 
	 * @param playlist
	 *            the play list
	 */
	public void add(Playlist playlist) {
		playlists.add(playlist);
	}

	/**
	 * Add the given track to the playlist.
	 * 
	 * @param track
	 *            the track to add
	 * @param playlist
	 *            the playlist
	 */
	public void add(Track track, Playlist playlist) {
		// TODO Iterate over the playlists and get the item and then add the
		// track to the playlists or We could also use a Map
	}

	/**
	 * Save the currently playing tracks into a new playlist.
	 * 
	 * @param title
	 *            playlist title
	 */
	public void savePlaylist(String title) {
		// TODO logic to save the current tracks to a playlist
	}

	/**
	 * Play the selected track.
	 * 
	 * @param track
	 *            the track to play
	 */
	public void play(Track track) {
		player.play(track);
	}

	/**
	 * Play the selected album.
	 * 
	 * @param album
	 *            the album to play
	 */
	public void play(Album album) {
		player.play(album.getTracks());
	}

	/**
	 * Play the selected playlist.
	 * 
	 * @param playlist
	 *            the playlist to play
	 */
	public void play(Playlist playlist) {
		player.play(playlist.getTracks());
	}
}
