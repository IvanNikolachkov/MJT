package fmi.mjt.filter;

import fmi.mjt.accommodation.Bookable;
import fmi.mjt.accommodation.location.Location;

public class LocationCriterion implements Criterion {

	private Location currenLocation;
	private double maxDistance;

	public LocationCriterion(Location currentLocation, double maxDistance) {
		this.currenLocation = currentLocation;
		this.maxDistance = maxDistance;
	}

	@Override
	public boolean check(Bookable bookable) {
		if (bookable == null) {
			return false;
		}
		double distance = Math.pow((Math.abs(currenLocation.getX() - bookable.getLocation().getX())), 2)
				+ Math.pow((Math.abs(currenLocation.getY() - bookable.getLocation().getY())), 2);

		if (maxDistance <= Math.sqrt(distance)) {
			return true;
		}
		return false;
	}

}
