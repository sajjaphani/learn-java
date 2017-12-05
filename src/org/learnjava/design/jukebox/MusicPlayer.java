package org.learnjava.design.jukebox;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Music player, allows to play track(s), enqueue new tracks.
 * 
 * @author psajja
 *
 */
public class MusicPlayer {
	private Queue<Track> playingQueue;

	public MusicPlayer() {
		playingQueue = new LinkedList<>();
	}

	/**
	 * Play the current selected track.
	 * 
	 * @param track
	 *            the track to play
	 */
	public void play(Track track) {
		playingQueue.clear();
		playingQueue.add(track);
		play(playingQueue);
	}

	/**
	 * Play the selected album.
	 * 
	 * @param album
	 *            the album to play
	 */
	public void play(List<Track> tracks) {
		playingQueue.clear();
		playingQueue.addAll(tracks);
		play(playingQueue);
	}

	/**
	 * Play the current queue.
	 * 
	 * @param playingQueue
	 *            the current queue
	 */
	private void play(Queue<Track> playingQueue) {
		for (Track track : playingQueue)
			track.play();
	}

	/**
	 * Add a track to the queue.
	 * 
	 * @param track
	 *            the track
	 */
	public void addToQueue(Track track) {
		playingQueue.add(track);
	}

	/**
	 * Add an album to the queue.
	 * 
	 * @param album
	 *            the album
	 */
	public void addToQueue(List<Track> tracks) {
		playingQueue.addAll(tracks);
	}
}