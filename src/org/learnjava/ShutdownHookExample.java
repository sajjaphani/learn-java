package org.learnjava;

/**
 * Shutdown hooks allows developers to plug in a piece of code to be executed
 * when the JVM is shutting down. <a href=
 * "https://docs.oracle.com/javase/1.5.0/docs/guide/lang/hook-design.html">
 * Design of the Shutdown Hooks API</a> provides details regarding design
 * decisions of the Java Shutdown Hooks API
 * 
 * @author psajja
 *
 */
public class ShutdownHookExample {

	public static void main(String[] args) {
		System.out.println("Main Thread started");
		Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHookRunnable()));
		System.out.println("Exiting main thread");
		System.exit(0);
	}

	/**
	 * Shutdown hook.
	 * 
	 * @author psajja
	 *
	 */
	static class ShutdownHookRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Running shutdown hook!");
		}
	}
}
