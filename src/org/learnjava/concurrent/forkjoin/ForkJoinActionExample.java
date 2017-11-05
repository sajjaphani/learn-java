package org.learnjava.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Example of ForkJoinTask which does not return any result.
 * 
 * @author psajja
 *
 */
public class ForkJoinActionExample {

	public static void main(String[] args) {
		ForkJoinPool pool = ForkJoinPool.commonPool();

		System.out.println("Parallelism: " + pool.getParallelism());
		System.out.println();

		RecursiveAction action = new CustomRecursiveAction(128);
		pool.invoke(action);
		pool.shutdown();
	}

	/**
	 * Recursive action.
	 * 
	 * @author psajja
	 *
	 */
	static class CustomRecursiveAction extends RecursiveAction {
		private static final long serialVersionUID = 5251958148622693799L;
		private static final int THRESOLD = 16;
		private long workLoad;

		public CustomRecursiveAction(long workLoad) {
			this.workLoad = workLoad;
		}

		@Override
		protected void compute() {
			if (workLoad > THRESOLD) {
				System.out.println("Splitting workLoad of " + workLoad + " units");
				ForkJoinTask.invokeAll(createSubtasks());
			} else {
				process();
			}
		}

		private void process() {
			System.out.println("Doing work of " + workLoad + " units");
		}

		private List<CustomRecursiveAction> createSubtasks() {
			List<CustomRecursiveAction> subtasks = new ArrayList<>();
			subtasks.add(new CustomRecursiveAction(workLoad / 2));
			subtasks.add(new CustomRecursiveAction(workLoad / 2));

			return subtasks;
		}
	}
}
