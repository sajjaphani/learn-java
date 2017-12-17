package org.learnjava.design.parkinglot;

/**
 * Represents a car.
 * 
 * @author psajja
 *
 */
public class Car extends Vehicle {
	public Car(String licencePlate) {
		super(licencePlate);
	}

	@Override
	public VehicleSize getSize() {
		return VehicleSize.Compact;
	}

	@Override
	public int getSpotsNeeded() {
		return 1;
	}

	@Override
	public boolean canFit(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}
}
