package org.learnjava.j8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * When ever we are iterating through a collection we use <code>Iterator</code>
 * interface. This example demonstrates the use of iterators.
 * <p>
 * Prior to Java 8, the collections framework provides a means to enumerate its
 * elements through <code>Iterator</code> interface known as external iteration.
 * Clients use this interface to access the elements inside of a collection.
 * </p>
 * <p>
 * Java 8 introduces external iteration over a collection, where the clients can
 * focus on what to do with the elements rather than controlling the iteration.
 * </p>
 * 
 * @author psajja
 *
 */
public class IteratorExample {

	/**
	 * Create a collection out of words from the given sentence.
	 * 
	 * @param sentence
	 * 		given sentence
	 * 
	 * @return
	 * 		collection of words, it creates a list
	 */
	private static Collection<String> getWords(String sentence) {
		return Arrays.asList(sentence.split(" "));
	}
	
	/**
	 * This method uses 'for-each' loop to print the elements.
	 * This limits the controlling of the collection elements.
	 * 
	 * @param words
	 * 		given collection
	 */
	private static void printElementsThroughExternalIteration(Collection<String> words) {
		System.out.println("Printing element through external iteration (for-each)...");
		for (String work : words) {
			System.out.println(work);
		}
	}
	
	/**
	 * This method uses Iterator interface to print the elements.
	 * With this we can control the collection elements while accessing(E.g, remove an element).
	 * 
	 * @param words
	 * 		given collection
	 */
	private static void printElementsThroughExternalIteration1(Collection<String> words) {
		System.out.println("Printing element through external iteration (Iterator interface)...");
		Iterator<String> iterator = words.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/**
	 * This method uses internal iterator in {@code Iterable#forEach(java.util.function.Consumer)}.
	 * 
	 * @param words
	 * 		given collection
	 */
	private static void printElementsThroughInternalIteration(Collection<String> words) {
		System.out.println("Printing element through internal iteration...");
		words.forEach(new Consumer<String>() {
	
			@Override
			public void accept(String word) {
				System.out.println(word);
			}
		});
	}
	
	/**
	 * Main client.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("External Iteration 1");
		Collection<String> list = getWords("Java 7 is good!");
		printElementsThroughExternalIteration(list);
		
		System.out.println();
		System.out.println("External Iteration 2");
		printElementsThroughExternalIteration1(list);
		
		System.out.println();
		System.out.println("Internal Iteration");
		Collection<String> list1 = getWords("Java 7 is awesome!");
		printElementsThroughInternalIteration(list1);
	}
}
