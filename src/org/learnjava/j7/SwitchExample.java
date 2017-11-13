package org.learnjava.j7;

/**
 * From Java 7, strings can be used in the expression of switch statements.
 * Prior to Java 7, we need to write a bunch of if else statements for the same.
 * 
 * @author psajja
 *
 */
public class SwitchExample {

	public static void main(String[] args) {
		System.out.println(getTypeOfDayWithIfStatement("Wednesday"));
		System.out.println(getTypeOfDayWithSwitchStatement("Monday"));
	}

	/**
	 * Pre Java 7.
	 * 
	 * @param dayOfWeek
	 *            day of week
	 * 
	 * @return a statement
	 */
	private static String getTypeOfDayWithIfStatement(String dayOfWeek) {
		if ("Monday".equals(dayOfWeek))
			return "Start of work week";
		if ("Tuesday".equals(dayOfWeek) || "Wednesday".equals(dayOfWeek) || "Thursday".equals(dayOfWeek))
			return "Midweek";
		if ("Friday".equals(dayOfWeek))
			return "End of work week";
		if ("Saturday".equals(dayOfWeek) || "Sunday".equals(dayOfWeek))
			return "Weekend";

		throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);

	}

	/**
	 * From Java 7.
	 * 
	 * @param dayOfWeek
	 *            day of week
	 * 
	 * @return a statement
	 */
	private static String getTypeOfDayWithSwitchStatement(String dayOfWeek) {
		switch (dayOfWeek) {
		case "Monday":
			return "Start of work week";
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
			return "Midweek";
		case "Friday":
			return "End of work week";
		case "Saturday":
		case "Sunday":
			return "Weekend";
		default:
			throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
		}

	}
}
