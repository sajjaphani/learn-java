package org.learnjava.design;

/**
 * Clients should not be forced to depend upon interfaces that they don't use.
 * <p>
 * When we write our interfaces we should take care to add only methods that
 * should be there. If we add methods that should not be there the classes
 * implementing the interface will have to implement those methods as well.
 * Interfaces containing methods that are not specific to it are called polluted
 * or fat interfaces. We should avoid them.
 * </p>
 * <p>
 * This principle deals with the disadvantages of "fat" interfaces. Classes that
 * have "fat" interfaces are classes whose interfaces are not cohesive. In other
 * words, the interfaces of the class can be broken up into groups of member
 * functions. Each group serves a different set of clients. Thus some clients
 * use one group of member functions, and other clients use the other groups.
 * </p>
 * 
 * @author psajja
 *
 */
public class InterfaceSegregationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Print Nothing.");
		Timer time = new Timer();
		TimedDoor door = new TimedDoor();
		time.Regsiter(0, door);
	}

	/**
	 * Door interface.
	 * 
	 */
	static interface IDoor {

		public void lock();

		void unlock();

		boolean isDoorOpen();
	}

	/**
	 * Represents a timer client.
	 * 
	 */
	static interface ITimerClient {
		void timeOut();
	}

	/**
	 * Timer which notifies the registered clients when timeout happen.
	 * 
	 */
	static class Timer {

		public void Regsiter(int timeout, ITimerClient client) {
		}
	}

	/**
	 * A normal door.
	 * 
	 */
	static class SimpleDoor implements IDoor {

		@Override
		public void lock() {
			System.out.println("Locking the door.");
		}

		@Override
		public void unlock() {
			System.out.println("Unlocking the door.");
		}

		@Override
		public boolean isDoorOpen() {
			return false;
		}
	}

	/**
	 * Timed door.
	 * 
	 */
	static class TimedDoor implements IDoor, ITimerClient {

		@Override
		public void timeOut() {
			System.out.println("Timeout happend, take necessary actions...");
		}

		@Override
		public void lock() {
			System.out.println("Lock timed door.");
		}

		@Override
		public void unlock() {
			System.out.println("Unlock timed door.");
		}

		@Override
		public boolean isDoorOpen() {
			return false;
		}
	}

	/*********************************************************************************
	 * One more example here
	 *********************************************************************************/

	/**
	 * An interface to represent a shape. All shapes does not have volume. Here
	 * we are forcing clients to provide default implementation.
	 * 
	 */
	static interface IShapeWithAreaAndVolume {

		public int getArea();

		public int getVolume();
	}

	// Better decomposition
	
	/**
	 * Shape interface
	 * 
	 */
	static interface IShape {

		public double getArea();
	}
	
	/**
	 * Solid shape interface.
	 * 
	 */
	interface ISolidShape {
	    public double getVolume();
	}
	
	/**
	 * A concrete shape
	 * 
	 */
	class Square implements IShape {

		@Override
		public double getArea() {
			return 0;
		}
	}

	/**
	 * Cube has area and volume.
	 * 
	 */
	class Cube implements IShape, ISolidShape {

		@Override
		public double getVolume() {
			return 0;
		}

		@Override
		public double getArea() {
			return 0;
		}

	}   
}
