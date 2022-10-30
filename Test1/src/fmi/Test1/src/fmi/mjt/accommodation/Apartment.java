package fmi.mjt.accommodation;

import fmi.mjt.accommodation.location.Location;

public class Apartment extends Property {

	private static int numOfInstances = 0;

	public Apartment(Location location, double pricePerNight) {
		super(location, pricePerNight);
		this.id = "APA-" + numOfInstances;
		numOfInstances++;
	}
}
