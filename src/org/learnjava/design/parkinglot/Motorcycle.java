package org.learnjava.design.parkinglot;

public class Motorcycle extends Vehicle {
	public Motorcycle(String licencePlate) {
		super(licencePlate);
	}

	public boolean canFit(ParkingSpot spot) {
		return true;
	}

	@Override
	public VehicleSize getSize() {
		return VehicleSize.Small;
	}

	@Override
	public int getSpotsNeeded() {
		return 1;
	}
}
