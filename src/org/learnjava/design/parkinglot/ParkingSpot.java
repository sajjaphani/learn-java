package org.learnjava.design.parkinglot;

/**
 * Represents a parking spot where a single vehicle can be fit.
 * 
 * @author psajja
 *
 */
public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize size;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level level, int row, int spotNumber, VehicleSize size) {
		this.level = level;
		this.row = row;
		this.spotNumber = spotNumber;
		this.size = size;
	}

	private boolean isAvailable() {
		return vehicle == null;
	}

	public boolean canFit(Vehicle vehicle) {
		return isAvailable() && vehicle.canFit(this);
	}

	public boolean park(Vehicle v) {
		if (!canFit(v)) {
			return false;
		}
		vehicle = v;

		return true;
	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public VehicleSize getSize() {
		return size;
	}

	/**
	 * Remove the parked vehicle.
	 */
	public void remove() {
		level.spotFreed();
		vehicle = null;
	}
}
