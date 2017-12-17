package org.learnjava.design.parkinglot;

/**
 * Represents a vehicle.
 * 
 * @author psajja
 *
 */
public abstract class Vehicle {
	private String licensePlate;

	public Vehicle(String licencePlate) {
		this.licensePlate = licencePlate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Get the number of spots requried to fit the vehicle.
	 * 
	 * @return number of spots
	 */
	public abstract int getSpotsNeeded();

	/**
	 * Get the size of the vehicle.
	 * 
	 * @return vehicle size
	 */
	public abstract VehicleSize getSize();

	/**
	 * Check the vehicle can fit in the given spot.
	 * 
	 * @param spot
	 * 		given spot
	 * 
	 * @return
	 * 		true if it can fit, false otherwise
	 */
	public abstract boolean canFit(ParkingSpot spot);

}
