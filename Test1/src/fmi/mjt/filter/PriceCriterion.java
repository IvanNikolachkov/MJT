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

}