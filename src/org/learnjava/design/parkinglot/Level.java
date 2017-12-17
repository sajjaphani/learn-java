package org.learnjava.design.parkinglot;

/**
 * Level comprises of parking spots.
 * 
 * @author psajja
 *
 */
public class Level {
	private static final int SPOTS_PER_ROW = 10;

	private int floorNum;
	private ParkingSpot[] spots;
	protected int numberOfSpots;
	private int availableSpots = 0;

	public Level(int floorNum, int numberOfSpots) {
		this.floorNum = floorNum;
		this.numberOfSpots = numberOfSpots;
		this.availableSpots = numberOfSpots;
		initSpots(numberOfSpots);
	}

	private void initSpots(int numberOfSpots) {
		this.spots = new ParkingSpot[numberOfSpots];
		int largeSpots = numberOfSpots / 4;
		int smallSpots = numberOfSpots / 4;
		int compactSpots = numberOfSpots - largeSpots - smallSpots;
		for (int spotNum = 0; spotNum < numberOfSpots; spotNum++) {
			VehicleSize size = VehicleSize.Small;
			if (spotNum < largeSpots)
				size = VehicleSize.Large;
			else if (spotNum < largeSpots + compactSpots)
				size = VehicleSize.Compact;

			spots[spotNum] = new ParkingSpot(this, spotNum / SPOTS_PER_ROW, spotNum, size);
		}
	}

	/**
	 * Park the vehicle.
	 * 
	 * @param vehicle
	 *            vehicle
	 * 
	 * @return if parked, false otherwise
	 */
	public boolean parkVehicle(Vehicle vehicle) {
		if (availableSpots() < vehicle.getSpotsNeeded())
			return false;

		int spotNumber = findSpot(vehicle);
		if (spotNumber < 0)
			return false;

		return parkStartingAtSpot(vehicle, spotNumber);
	}

	/**
	 * Park the vehicle.
	 * 
	 * @param spotNumber
	 *            spot number
	 * @param vehicle
	 *            vehicle
	 * 
	 * @return true if it can fit, false otherwise
	 */
	private boolean parkStartingAtSpot(Vehicle vehicle, int spotNumber) {
		boolean success = true;
		for (int i = spotNumber; i < spotNumber + vehicle.getSpotsNeeded(); i++)
			success &= spots[i].park(vehicle);

		availableSpots -= vehicle.getSpotsNeeded();

		return success;
	}

	/**
	 * Find the spot to park the vehicle.
	 * 
	 * @param vehicle
	 *            given vehicle
	 * 
	 * @return return index of the spot, or -1 if not available
	 */
	private int findSpot(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (lastRow != spot.getRow()) {
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFit(vehicle))
				spotsFound++;
			else
				spotsFound = 0;

			if (spotsFound == spotsNeeded)
				return i - (spotsNeeded - 1);
		}

		return -1;
	}

	/**
	 * Spot is freed.
	 */
	public void spotFreed() {
		availableSpots++;
	}

	public int getFloorNum() {
		return floorNum;
	}

	private int availableSpots() {
		return availableSpots;
	}
}
