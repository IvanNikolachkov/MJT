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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currenLocation == null) ? 0 : currenLocation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maxDistance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationCriterion other = (LocationCriterion) obj;
		if (currenLocation == null) {
			if (other.currenLocation != null)
				return false;
		} else if (!currenLocation.equals(other.currenLocation))
			return false;
		if (Double.doubleToLongBits(maxDistance) != Double.doubleToLongBits(other.maxDistance))
			return false;
		return true;
	}

}
