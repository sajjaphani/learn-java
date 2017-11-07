package org.learnjava.design;

/**
 * Don't call us, we'll call you.
 * <p>
 * The Hollywood principle gives us a way to prevent "dependency rot."
 * Dependency rot happens when you have high-level components depending on
 * low-level components depending on high-level components depending on sideways
 * components depending on low-level components, and so on. When rot sets in, no
 * one can easily understand the way a system is designed.
 * </p>
 * <p>
 * With the Hollywood Principle, we allow low-level components to hook
 * themselves into a system, but the high-level components determine when they
 * are needed, and how. In other words, the high-level components give the
 * low-level components a "don't call us, we'l call you" treatment.
 * </p>
 * <p>
 * The connection between the Hollywood Principle and the Template Method
 * Pattern is probably somewhat apparent: when we design with the Template
 * Method Pattern, we're telling subclasses, "don't call us, we'll call you."
 * </p>
 * 
 * @author psajja
 *
 */
public class HollywoodPrincipleExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CaffeineBeverage coffee = new Coffee();
		System.out.println("Making coffee...");
		coffee.prepareRecipe();

		System.out.println();
		CaffeineBeverage tea = new Tea();
		System.out.println("Making tea...");
		tea.prepareRecipe();
	}

	/**
	 * CaffeineBeverage is our high-level component. It has control over the
	 * algorithm for the recipe, and calls on the subclasses only when they’re
	 * needed for an implementation of a method.
	 */
	static abstract class CaffeineBeverage {

		final void prepareRecipe() {
			boilWater();
			brew();
			pourInCup();
			addCondiments();
		}

		abstract void brew();

		abstract void addCondiments();

		void boilWater() {
			System.out.println("Boiling water");
		}

		void pourInCup() {
			System.out.println("Pouring into cup");
		}
	}

	/**
	 * A coffee.
	 * 
	 * The 'brew' and 'addCnidemts' are the methods we need to implement to
	 * "fill out" the template method.
	 */
	static class Coffee extends CaffeineBeverage {

		public void brew() {
			System.out.println("Dripping Coffee through filter");
		}

		public void addCondiments() {
			System.out.println("Adding Sugar and Milk");
		}
	}

	/**
	 * A lemon tea.
	 * 
	 * The 'brew' and 'addCnidemts' are the methods we need to implement to
	 * "fill out" the template method.
	 */
	static class Tea extends CaffeineBeverage {

		public void brew() {
			System.out.println("Steeping the tea");
		}

		public void addCondiments() {
			System.out.println("Adding Lemon");
		}
	}
}
