package fmi.mjt;

import java.util.Arrays;

import fmi.mjt.accommodation.Bookable;
import fmi.mjt.filter.Criterion;

public class Airbnb implements AirbnbAPI {

	private Bookable[] bookables;

	public Airbnb(Bookable[] accommodations) {
		this.bookables = accommodations;
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

// 	@Override
// 	public int hashCode() {
// 		final int prime = 31;
// 		int result = 1;
// 		result = prime * result + Arrays.hashCode(bookables);
// 		return result;
// 	}

// 	@Override
// 	public boolean equals(Object obj) {
// 		if (this == obj)
// 			return true;
// 		if (obj == null)
// 			return false;
// 		if (getClass() != obj.getClass())
// 			return false;
// 		Airbnb other = (Airbnb) obj;
// 		if (!Arrays.equals(bookables, other.bookables))
// 			return false;
// 		return true;
// 	}

}
