package org.learnjava.design.parkinglot;

/**
 * Represents a bus.
 * 
 * @author psajja
 *
 */
public class Bus extends Vehicle {
	
	public Bus(String licencePlate) {
		super(licencePlate);
	}

	@Override
	public VehicleSize getSize() {
		return VehicleSize.Large;
	}
	
	@Override
	public int getSpotsNeeded() {
		return 5;
	}

	@Override
	public boolean canFit(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large;
	}
}
