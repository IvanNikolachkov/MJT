package fmi.mjt.accommodation;

import fmi.mjt.accommodation.location.Location;

public class Hotel extends Property {

	private static int numOfInstances = 0;

	public Hotel(Location location, double pricePerNight) {
		super(location, pricePerNight);
		this.id = "HOT-" + numOfInstances;
		numOfInstances++;
	}
}
