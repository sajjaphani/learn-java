package org.learnjava.concurrent.dinning;

/**
 * Philosopher thread.
 * 
 * @author psajja
 *
 */
public class Philosopher implements Runnable {
	private int id;
	private Fork left;
	private Fork right;

	public Philosopher(int id, Fork left, Fork right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Philosopher " + id + " Thinking");

				pickUp();

				System.out.println("Philosopher " + id + " started eating.");
				Thread.sleep(1000);
				System.out.println("Philosopher " + id + " finished eating.");

				putDown();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void putDown() {
		right.putDown();
		System.out.println("Philosopher " + id + " Put down right fork.");
		left.putDown();
		System.out.println("Philosopher " + id + " Put down left fork.");
	}

	private void pickUp() {
		left.pickUp();
		System.out.println("Philosopher " + id + " Picked up left fork.");
		right.pickUp();
		System.out.println("Philosopher " + id + " Picked up right fork.");
	}
}
