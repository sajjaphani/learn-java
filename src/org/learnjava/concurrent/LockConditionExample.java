package org.learnjava.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition factors out the Object monitor methods (wait, notify and notifyAll)
 * into distinct objects to give the effect of having multiple wait-sets per
 * object, by combining them with the use of arbitrary Lock implementations.
 * Where a Lock replaces the use of synchronized methods and statements, a
 * Condition replaces the use of the Object monitor methods.
 * 
 * @author psajja
 *
 */
public class LockConditionExample {

	public static void main(String[] args) {
		final BoundedBuffer<String> queue = new BoundedBuffer<>(10);

		// One producer and one consumer
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

	/**
	 * Producer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Producer implements Runnable {
		protected BoundedBuffer<String> queue;
		static int count;

		public Producer(BoundedBuffer<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Putting Item " + ++count);
					queue.add("Item " + count);
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Consumer thread.
	 * 
	 * @author psajja
	 *
	 */
	static class Consumer implements Runnable {
		protected BoundedBuffer<String> queue;

		public Consumer(BoundedBuffer<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Taking " + queue.remove());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class BoundedBuffer<E> {
		final Lock lock;
		final Condition notFull;
		final Condition notEmpty;

		final Queue<E> items;
		int putptr, takeptr, size;

		public BoundedBuffer(int size) {
			this.size = size;
			items = new LinkedList<>();
			lock = new ReentrantLock();
			notFull = lock.newCondition();
			notEmpty = lock.newCondition();
		}

		public void add(E obj) throws InterruptedException {
			lock.lock();
			try {
				while (size == items.size())
					notFull.await();
				items.add(obj);
				notEmpty.signal();
			} finally {
				lock.unlock();
			}
		}

		@SuppressWarnings("unchecked")
		public E remove() throws InterruptedException {
			lock.lock();
			try {
				while (size == 0)
					notEmpty.await();
				Object x = items.remove();
				notFull.signal();
				return (E) x;
			} finally {
				lock.unlock();
			}
		}
	}
}
