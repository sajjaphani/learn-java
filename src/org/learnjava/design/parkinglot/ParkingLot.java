package org.learnjava.design.parkinglot;

/**
 * Parking lot comprises of multiple levels.
 * 
 * @author psajja
 *
 */
public class ParkingLot {
	private Level[] levels;
	private final int NUM_OF_LEVELS;

	public ParkingLot(int numOfLevels) {
		NUM_OF_LEVELS = numOfLevels;
		levels = new Level[NUM_OF_LEVELS];
		for (int i = 0; i < NUM_OF_LEVELS; i++)
			levels[i] = new Level(i, 50);
	}

	/**
	 * Park the given vehicle.
	 * 
	 * @param vehicle
	 *            the vehicle.
	 * 
	 * @return
	 */
	public boolean park(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle))
				return true;
		}

		return false;
	}
}
