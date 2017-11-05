/**
 * ForkJoinPool was added in Java 7 and is similar to the Java ExecutorService
 * but differs mainly by virtue of employing work-stealing. Fork-Join splits the
 * task at hand into smaller -tasks until the small task is simple enough that
 * it can be solved without further breakups. It is like a divide-and-conquer
 * approach.
 * <p>
 * we can submit ForkJoinTask tasks to a ForkJoinPool similar to submitting
 * tasks to an ExecutorService. There are two types of tasks we can submit.
 * RecursiveAction, a task that does not return any result. RecursiveTask, a
 * task that returns a result upon completion.
 * 
 * </p>
 * 
 * @author psajja
 *
 */
package org.learnjava.concurrent.forkjoin;