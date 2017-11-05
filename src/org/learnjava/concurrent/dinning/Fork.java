package org.learnjava.concurrent.dinning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Fork.
 * 
 * @author psajja
 *
 */
public class Fork {
	private Lock lock;

	public Fork() {
		lock = new ReentrantLock();
	}

	public void pickUp() {
		lock.lock();
	}

	public void putDown() {
		lock.unlock();
	}
}