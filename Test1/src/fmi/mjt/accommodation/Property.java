package fmi.mjt.accommodation;

import java.time.LocalDateTime;

import fmi.mjt.accommodation.location.Location;

abstract class Property implements Bookable {

	protected String id;
	protected Location location;
	protected double pricePerNight;
	protected boolean booked = false;
	protected int days = 0;

	public  Property(Location location, double pricePerNight) {
		this.location = location;
		this.pricePerNight = pricePerNight;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public boolean isBooked() {
		return booked;
	}

	@Override
	public boolean book(LocalDateTime checkIn, LocalDateTime checkOut) {
		int dayIn = checkIn.getDayOfYear();
		int dayOut = checkOut.getDayOfYear();
		if (this.isBooked() || checkIn == null || checkOut == null || dayIn > dayOut) {
			return false;
		}

		this.days = dayOut - dayIn;
		this.booked = true;
		return true;
	}

	@Override
	public double getTotalPriceOfStay() {
		return this.days * this.pricePerNight;
	}

	@Override
	public double getPricePerNight() {
		return this.pricePerNight;
	}
}
