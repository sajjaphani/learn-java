package org.learnjava.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java 5 introduced <code>java.util.concurrent.Callable</code> interface, which
 * is similar to Runnable interface but it can return a value and able to throw
 * Exception. Callable tasks return <code>java.util.concurrent.Future</code>
 * object. Using Future object, we can find out the status of the task and get
 * the result.
 * 
 * @author psajja
 *
 */
public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<Integer> adder = new AdderCallable(20, 30);
		Future<Integer> feature = executor.submit(adder);
		System.out.println(feature.get());
	}

	/**
	 * A callable adder.
	 * 
	 * @author psajja
	 *
	 */
	static class AdderCallable implements Callable<Integer> {
		Integer operand1;
		Integer operand2;

		public AdderCallable(Integer operand1, Integer operand2) {
			this.operand1 = operand1;
			this.operand2 = operand2;
		}

		@Override
		public Integer call() throws Exception {
			return operand1 + operand2;
		}
	}
}
