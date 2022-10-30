package fmi.mjt.accommodation;

import fmi.mjt.accommodation.location.Location;

public class Villa extends Property {

	private static int numOfInstances = 0;

	public Villa(Location location, double pricePerNight) {
		super(location, pricePerNight);
		this.id = "VIL-" + numOfInstances;
		numOfInstances++;
	}
}
