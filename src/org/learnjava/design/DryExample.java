package org.learnjava.design;

import java.util.Timer;
import java.util.TimerTask;

/**
 * DRY - Don't repeat yourself.
 * <p>
 * Avoid duplicate code by abstracting out things that are common and placing
 * those things in a single location. DRY is about having each piece of
 * information and behavior in your system in a single, sensible place.
 * </p>
 * <p>
 * DRY is really about one requirement in one place. Abstracting out duplicate
 * code is a good start to using DRY. When you are trying to avoid duplicate
 * code, you are really trying to make sure that you only implement each feature
 * and requirement in your application one single time.
 * </p>
 * <p>
 * DRY is about avoiding duplicate code, but it's also about doing it in a way
 * that won't create more problems down the line. Rather than just tossing code
 * that appears more than once into a single class, you need to make sure each
 * piece of information and behavior in your system has a single, clear place
 * where it exists. That way, your system always knows exactly where to go when
 * it needs that information or behavior.
 * </p>
 * 
 * @author psajja
 *
 */
public class DryExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Print Nothing");
	}

	/**
	 * This is an automatic door once it opened it closes automatically after 5
	 * seconds. Door opening can be done when the remove is pressed or a dog
	 * bark is recognized. Having this in this class is the correct place.
	 *
	 */
	static class DogDoor {
		private boolean open;

		public void open() {
			System.out.println("The dog door opens.");
			open = true;

			final Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					close();
					timer.cancel();
				}
			}, 5000);
		}

		public void close() {
			System.out.println("The dog door closes.");
			open = false;
		}

		public boolean isOpen() {
			return open;
		}
	}

	/**
	 * Remove to control the door.
	 */
	static class Remote {
		private DogDoor door;

		public Remote(DogDoor door) {
			this.door = door;
		}

		public void pressButton() {
			System.out.println("Pressing the remote control button...");
			if (door.isOpen())
				door.close();
			else
				door.open();
		}
	}

	/**
	 * This recognizes the dog's bark
	 *
	 */
	static class BarkRecognizer {
		private DogDoor door;

		public BarkRecognizer(DogDoor door) {
			this.door = door;
		}

		public void recognize(String bark) {
			System.out.println("BarkRecognizer: Heard a '" + bark + "'");
			door.open();
		}
	}
}
