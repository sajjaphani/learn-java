package org.learnjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 * <a href=
 * "https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#fail-fast">
 * Fail-fast</a> iterators will throw a ConcurrentModificationException if the
 * collection is structurally modified at any time after the iterator is
 * created, with the exception of through the iterator's own remove or add
 * methods. Thus, in the face of concurrent modification, the iterator fails
 * quickly and cleanly, rather than risking arbitrary, non-deterministic
 * behavior at an undetermined time in the future. E.g, ArrayList, HasshMap,
 * HashSet. The fail-fast behavior of an iterator cannot be guaranteed as it is
 * impossible to make any hard guarantees in the presence of unsynchronized
 * concurrent modification
 * </p>
 * <p>
 * Fail-safe (<a href=
 * "https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html#Weakly">
 * Weakly-consistent</a>, technically correct term), does not throw a
 * ConcurrentModificationException if any collection is structurally modified
 * after the iterator is created. E.g, Most Queue implementations,
 * ConcurrentHashMap, ConcurrentSkipListMap, ConcurrentSkipListSet,
 * CopyOnWriteArrayList, and CopyOnWriteArraySet.
 * </p>
 * 
 * @author psajja
 *
 */
public class FailFastAndFailSafeIteratorExample {

	public static void main(String[] args) {

		List<String> companyList = new ArrayList<>();
		companyList.add("Apple");
		companyList.add("Google");
		// Uncommenting below statement will produce the concurrent modification exception
//		companyList.add("Lenovo"); 
		companyList.add("Lenovo");
		companyList.add("Samsung");

		System.out.println("List Before: " + companyList);
		failFastIterationRemoveButOne(companyList, "Lenovo");
		System.out.println("List After: " + companyList);
		
		List<String> companyList1 = new CopyOnWriteArrayList<>();
		companyList1.add("Apple");
		companyList1.add("Google");
		companyList1.add("Lenovo"); 
		companyList1.add("Lenovo");
		companyList1.add("Samsung");
		
		System.out.println();
		System.out.println("List Before: " + companyList1);
		weaklyConsistentIterationRemoveButOne(companyList1, "Lenovo");
		
		System.out.println("List After: " + companyList1);
	}

	private static void failFastIterationRemoveButOne(List<String> list, String companyName) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().compareTo(companyName) == 0) {
				list.remove(companyName);
			}
		}
		
		list.add(companyName);
	}

	private static void weaklyConsistentIterationRemoveButOne(List<String> list, String companyName) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().compareTo(companyName) == 0) {
				list.remove(companyName);
			}
		}
		
		list.add(companyName);
	}
}
