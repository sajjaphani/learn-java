package org.learnjava;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * The {@link Comparable} interface imposes a total ordering on the objects of
 * each class that implements it. This ordering is referred to as the class's
 * natural ordering..
 * </p>
 * <p>
 * Collections.sort (and Arrays.sort) methods can be used to sort the Lists (and
 * arrays) of objects that implement this interface. Objects that implement this
 * interface can be used as keys in a sorted map or as elements in a sorted set.
 * </p>
 * <p>
 * The natural ordering for a class that implement this interface should be
 * consistent with equals if and only if obj1.compareTo(obj2) == 0 has the same
 * boolean value as obj1.equals(obj2).
 * </p>
 * 
 * @author psajja
 *
 */
public class ComparableExample {

	public static void main(String[] args) {
		Employee[] employees = { new Employee("John", "Smith", LocalDate.of(2016, 3, 27)),
				new Employee("Jeff", "Smith", LocalDate.of(2017, 3, 12)),
				new Employee("Tom", "Rich", LocalDate.of(2017, 6, 22)),
				new Employee("Karl", "Ng", LocalDate.of(2016, 5, 9)),
				new Employee("John", "Smith", LocalDate.of(2017, 7, 15)) };
		
		List<Employee> empList = Arrays.asList(employees);
		
		System.out.println("Employees Before Sort");
		System.out.println(empList);
		
		Collections.sort(empList);
		System.out.println();
		System.out.println("Employees After Sort");
		System.out.println(empList);
	}

	/**
	 * compareTo implementation is based on the standard name-ordering
	 * algorithm, where last names take precedence over first names. Further it
	 * uses the dateOfJoin if last name and first name matches.
	 * 
	 * This class uses Java 8 immutable date {@link LocalDate}.
	 * 
	 * @author psajja
	 *
	 */
	static class Employee implements Comparable<Employee> {
		private final String firstName;
		private final String lastName;
		private final LocalDate dateOfJoin;

		public Employee(String firstName, String lastName, LocalDate dateOfJoin) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfJoin = dateOfJoin;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public LocalDate getDateOfJoin() {
			return dateOfJoin;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (!(obj instanceof Employee))
				return false;

			Employee other = (Employee) obj;

			return other.firstName.equals(firstName) && other.lastName.equals(lastName)
					&& other.dateOfJoin.equals(dateOfJoin);
		}

		@Override
		public int hashCode() {
			int hash = 17;
			hash = 31 * hash + firstName.hashCode();
			hash = 31 * hash + lastName.hashCode();
			hash = 31 * hash + dateOfJoin.hashCode();

			return hash;
		}

		@Override
		public int compareTo(Employee emp) {
			int cmp = lastName.compareTo(emp.lastName);
			if (cmp == 0)
				cmp = firstName.compareTo(emp.firstName);

			return (cmp != 0 ? cmp : dateOfJoin.compareTo(emp.dateOfJoin));
		}

		@Override
		public String toString() {
			return firstName + " " + lastName + " Joined on: " + dateOfJoin.toString();
		}
	}
}
