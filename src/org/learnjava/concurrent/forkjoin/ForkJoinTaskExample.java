package org.learnjava.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Example of ForkJoinTask which return result.
 * 
 * @author psajja
 *
 */
public class ForkJoinTaskExample {

	public static void main(String[] args) {
		ForkJoinPool pool = ForkJoinPool.commonPool();

		System.out.println("Parallelism: " + pool.getParallelism());
		System.out.println();
		int[] elements = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7,
				8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		RecursiveTask<Integer> action = new CustomRecursiveTask(elements);
		int result = pool.invoke(action);
		pool.shutdown();

		System.out.println("Result: " + result);
	}

	/**
	 * Recursive task.
	 * 
	 * @author psajja
	 *
	 */
	static class CustomRecursiveTask extends RecursiveTask<Integer> {
		private static final long serialVersionUID = -7081609933129335007L;
		private static final int THRESOLD = 16;

		private int[] elements;
		private long workLoad;

		public CustomRecursiveTask(int[] elements) {
			this.elements = elements;
			this.workLoad = elements.length;
		}

		@Override
		protected Integer compute() {
			if (this.workLoad > THRESOLD) {
				System.out.println("Splitting workLoad of " + workLoad + " units");
				Collection<CustomRecursiveTask> subTasks = ForkJoinTask.invokeAll(createSubtasks());
				int result = 0;
				for (CustomRecursiveTask subtask : subTasks)
					result += subtask.join();

				return result;
			} else {
				return process();
			}
		}

		private int process() {
			int sum = 0;
			for (int elt : elements)
				sum += elt;

			return sum;
		}

		private List<CustomRecursiveTask> createSubtasks() {
			List<CustomRecursiveTask> subTasks = new ArrayList<>();
			subTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(elements, 0, elements.length / 2)));
			subTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(elements, elements.length / 2, elements.length)));

			return subTasks;
		}
	}
}
