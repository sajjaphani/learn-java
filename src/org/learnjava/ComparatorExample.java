package org.learnjava;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.learnjava.ComparableExample.Employee;

/**
 * The {@link Comparable} interface imposes a total ordering on some collection
 * of objects. To precise control over the sort order Comparators can be passed
 * to a sort methods (such as Collections.sort or Arrays.sort). Comparators can
 * also be used to control the order of certain data structures (such as sorted
 * sets or sorted maps). They can be used to provide an ordering for collections
 * of objects that don't have a natural ordering.
 * 
 * @author psajja
 *
 */
public class ComparatorExample {

	public static void main(String[] args) {
		Employee[] employees = { new Employee("John", "Smith", LocalDate.of(2016, 3, 27)),
				new Employee("Jeff", "Smith", LocalDate.of(2017, 3, 12)),
				new Employee("Tom", "Rich", LocalDate.of(2017, 6, 22)),
				new Employee("Karl", "Ng", LocalDate.of(2016, 5, 9)),
				new Employee("John", "Smith", LocalDate.of(2017, 7, 15)) };

		List<Employee> empList = Arrays.asList(employees);

		System.out.println("Employees Before Sort");
		System.out.println(empList);

		Collections.sort(empList, new EmployeeSeniorityComparator());
		System.out.println();
		System.out.println("Employees After Sort");
		System.out.println(empList);
	}

	/**
	 * This comparator provides an ordering of employees based on their
	 * seniority in the company. We are using the {@link Employee} class and
	 * providing an ordering based on joining date.
	 * <p>
	 * There is still a chance that employees might join on the same date with
	 * the same name. We need some other way to distinguish such case. Lets not
	 * bother about such cases for this example for simplicity.
	 * </p>
	 * 
	 * @author psajja
	 *
	 */
	static class EmployeeSeniorityComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {

			int cmp = o1.getDateOfJoin().compareTo(o2.getDateOfJoin());
			if (cmp == 0)
				cmp = o1.getLastName().compareTo(o2.getLastName());

			return (cmp != 0 ? cmp : o1.getFirstName().compareTo(o2.getFirstName()));
		}
	}
}
