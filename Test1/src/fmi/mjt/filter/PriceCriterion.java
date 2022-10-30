package fmi.mjt.filter;

import fmi.mjt.accommodation.Bookable;

public class PriceCriterion implements Criterion {

	private double minPrice;
	private double maxPrice;

	public PriceCriterion(double minPrice, double maxPrice) {
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
	}

	@Override
	public boolean check(Bookable bookable) {

		if (bookable == null || bookable.getPricePerNight() <= minPrice || bookable.getPricePerNight() >= maxPrice) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(minPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxPrice);
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
		PriceCriterion other = (PriceCriterion) obj;
		if (Double.doubleToLongBits(minPrice) != Double.doubleToLongBits(other.minPrice))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		return true;
	}

}