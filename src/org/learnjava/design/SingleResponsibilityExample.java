package org.learnjava.design;

/**
 * <p>
 * A class should have only one reason to change.
 * </p>
 * <p>
 * Every responsibility of a class is an area of potential change. More than one
 * responsibility means more than one area of change. This principle states that
 * if we have more reasons to change for a class, we have to split the
 * functionality in to separate classes. Each class will handle only one
 * responsibility and on future if we need to make one change we are going to
 * make it in the class which handle it.
 * </p>
 * <p>
 * Cohesion is a term used as a measure of how closely a class or a module
 * supports a single purpose or responsibility. We say that a module or class
 * has high cohesion when it is designed around a set of related functions, and
 * we say it has low cohesion when it is designed around a set of unrelated
 * functions. Cohesion is a more general concept than the Single Responsibility
 * Principle, but the two are closely related.
 * </p>
 * 
 * @author psajja
 *
 */
public class SingleResponsibilityExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Print Nothing");
	}

	/*********************************************************************************
	 * More than one responsibility
	 *********************************************************************************/

	/**
	 * Below class is handling more than one responsibility. It is handling its
	 * own state as well as storing it self to a persistent store.
	 * 
	 */
	static class PersonWithManyResponsibilities {

		private String name;
		private String address;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void save() {
			// Do Persist itself
		}
	}

	/*********************************************************************************
	 * Moved responsibilities to its own class/interface
	 *********************************************************************************/

	/**
	 * Below class is handling one responsibility handling its own state.
	 * 
	 */
	static class Person {

		private String name;
		private String address;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	}

	/**
	 * We have moved the saving the Person to a separate interface. This way we
	 * can even support multiple types of persistent stores. E.g, a database, a
	 * file system etc.
	 * 
	 */
	static interface PersistentStore {
		public void save(Person person);
	}
}
