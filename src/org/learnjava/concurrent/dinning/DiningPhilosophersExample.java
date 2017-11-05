package org.learnjava.concurrent.dinning;

/**
 * There are five silent philosophers sitting around a circular table, spending
 * their lives thinking and eating. There are five forks for them to share and
 * to be able to eat, philosopher needs to have forks in both his hands.
 * <p>
 * To avoid deadlock, each philosopher picks up the left fork first and then the
 * right one except the last philosopher, where he picks in opposite order.
 * </p>
 * 
 * @author psajja
 *
 */
public class DiningPhilosophersExample {

	public static void main(String[] args) {
		int NO_OF_PHILOSOPHERS = 5;
		Fork[] forks = new Fork[NO_OF_PHILOSOPHERS];

		for (int i = 0; i < NO_OF_PHILOSOPHERS; i++)
			forks[i] = new Fork();

		for (int i = 0; i < NO_OF_PHILOSOPHERS - 1; i++)
			new Thread(new Philosopher(i + 1, forks[i], forks[i + 1])).start();

		new Thread(new Philosopher(NO_OF_PHILOSOPHERS, forks[0], forks[NO_OF_PHILOSOPHERS - 1])).start();
	}
}