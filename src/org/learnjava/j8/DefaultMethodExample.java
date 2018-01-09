package org.learnjava.j8;

/**
 * Default methods in Java 8 allows developers to add new methods to existing
 * interfaces without breaking the existing implementations. Default methods
 * allows to extend existing interfaces in a backward compatible way. Further
 * the implementing classes can choose to override the default implementation
 * provided by the interface.
 * 
 * <p>
 * In Java 8, we can also have static methods inside an interface.
 * </p>
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html">
 *      Default Methods</a>
 * 
 * @author psajja
 *
 */
public class DefaultMethodExample {

	/**
	 * Main Client
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IDate date = new Date(2017, 07, 18);
		System.out.println("YYYY-MM-DD format string through toString() method");
		System.out.println(date);

		System.out.println();
		System.out.println("Json string through default toJsonString() method");
		System.out.println(date.toJsonString());
	}

	/**
	 * Lets assume that we have an interface to represent a date which holds the
	 * date. Lets also assume that we want to add a method in this interface to
	 * return the Json string representation of the date, we can add a default
	 * method as shown in the toJsonString method.
	 * <p>
	 * Note: There are other mechanisms to get the Json representation of the
	 * date (e.g, a utility method), the sole purpose of this default method is
	 * to demonstrate the use of default methods.
	 * </p>
	 * 
	 * @author psajja
	 *
	 */
	public interface IDate {

		public int getYear();

		public int getMonth();

		public int getDay();

		/**
		 * This is a default method.
		 */
		default String toJsonString() {
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\n\t" + "\"year\": " + getYear() + ",");
			sb.append("\n\t" + "\"month\": " + getMonth() + ",");
			sb.append("\n\t" + "\"day\": " + getDay());
			sb.append("\n}");

			return sb.toString();
		}
	}

	/**
	 * A sample concrete implementation of the date interface.
	 * 
	 * @author psajja
	 *
	 */
	private static class Date implements IDate {
		int year;
		int month;
		int day;

		public Date(int year, int month, int day) {
			// TODO data validation
			this.year = year;
			this.month = month;
			this.day = day;
		}

		@Override
		public int getYear() {
			return year;
		}

		@Override
		public int getMonth() {
			return month;
		}

		@Override
		public int getDay() {
			return day;
		}

		@Override
		public String toString() {
			return getYear() + "-" + getMonth() + "-" + getDay();
		}
	}
}
