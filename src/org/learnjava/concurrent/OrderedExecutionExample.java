package org.learnjava.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Call methods in order form different threads. The same instance of a class
 * will be passed to three different threads. Thread A should call first thread
 * B should call second, and thread C should call third.
 * 
 * @author psajja
 *
 */
public class OrderedExecutionExample {

	public static void main(String[] args) {
		Foo foo = Foo.newFoo();

		new Thread(new FooRunner(foo, "first")).start();
		new Thread(new FooRunner(foo, "second")).start();
		new Thread(new FooRunner(foo, "third")).start();
	}

	/**
	 * Foo runner, each thread is responsible for runnging a single method.
	 * 
	 * @author psajja
	 *
	 */
	static class FooRunner implements Runnable {
		private String methodName;
		private Foo foo;

		public FooRunner(Foo foo, String methodName) {
			this.methodName = methodName;
			this.foo = foo;
		}

		@Override
		public void run() {
			if (methodName == "first") {
				foo.firstMethod();
			} else if (methodName == "second") {
				foo.secondMethod();
			} else if (methodName == "third") {
				foo.thirdMethod();
			}
		}
	}

	static class Foo {
		private Semaphore semaphore1 = new Semaphore(1);
		private Semaphore semaphore2 = new Semaphore(1);

		/**
		 * When initialized acquires both the locks.
		 */
		private Foo() {
			try {
				semaphore1.acquire();
				semaphore2.acquire();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		public static Foo newFoo() {
			return new Foo();
		}

		/**
		 * First method proceeds execution from a thread and releases the
		 * semaphore 1.
		 * 
		 */
		public void firstMethod() {
			try {
				System.out.println("Started Executing 'firstMethod'");
				Thread.sleep(500);
				System.out.println("Finished Executing 'firstMethod'");
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				semaphore1.release();
			}
		}

		/**
		 * Second method makes sure that the first is executed by acquiring and
		 * releases the lock on the semaphore 1. When finished execution
		 * releases the lock on semaphore 2.
		 * 
		 */
		public void secondMethod() {
			try {
				semaphore1.acquire();
				semaphore1.release();
				System.out.println("Started Executing 'secondMethod'");
				Thread.sleep(500);
				System.out.println("Finished Executing 'secondMethod'");
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				semaphore2.release();
			}
		}

		/**
		 * When second method execution finished, it can simply acquire the lock
		 * on second semaphore and proceeds.
		 */
		public void thirdMethod() {
			try {
				semaphore2.acquire();
				System.out.println("Started Executing 'thirdMethod'");
				Thread.sleep(500);
				System.out.println("Finished Executing 'thirdMethod'");
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				semaphore2.release();
			}
		}
	}
}