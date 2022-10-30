package fmi.mjt;

import fmi.mjt.accommodation.Bookable;
import fmi.mjt.filter.Criterion;

public class Airbnb implements AirbnbAPI {

	Bookable[] bookables;

	public Airbnb(Bookable[] accommodations) {
		this.bookables = new Bookable[accommodations.length];
		for (int i = 0; i < accommodations.length; i++) {
			bookables[i] = accommodations[i];
		}
	}

	@Override
	public Bookable findAccommodationById(String id) {
		if (id == null || id.isBlank()) {
			return null;
		}
		for (Bookable b : this.bookables) {
			if (b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public double estimateTotalRevenue() {
		double estimateRevenue = 0;
		for (Bookable b : bookables) {
			estimateRevenue += b.getTotalPriceOfStay();
		}
		return estimateRevenue;
	}

	@Override
	public long countBookings() {
		long bookedCount = 0;
		for (Bookable b : bookables) {
			if (b.isBooked()) {
				bookedCount++;
			}
		}
		return bookedCount;
	}

	@Override
	public Bookable[] filterAccommodations(Criterion... criteria) {
		Bookable[] filteredAccommodations = new Bookable[bookables.length];
		int numOfFilteredAcc = 0;
		int criteriaPassed = 0;

		for (Bookable b : bookables) {
			for (Criterion c : criteria) {
				if (c.check(b)) {
					criteriaPassed++;
				}
			}

			if (criteriaPassed == criteria.length) {
				filteredAccommodations[numOfFilteredAcc] = b;
				numOfFilteredAcc++;
			}
			criteriaPassed = 0;
		}
		
		Bookable[] finalFilteredAcc = new Bookable[numOfFilteredAcc];
		for (int i = 0; i < numOfFilteredAcc; i++) {
			finalFilteredAcc[i] = filteredAccommodations[i];
		}
		return finalFilteredAcc;
	}
}
