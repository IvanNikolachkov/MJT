package fmi.mjt;

import fmi.mjt.accommodation.Apartment;
import fmi.mjt.accommodation.Bookable;
import fmi.mjt.accommodation.Hotel;
import fmi.mjt.accommodation.Villa;

public class Main {
	public static void main(String... args){

		Bookable hotel1 = new Hotel(null, 0);
		Bookable villa1 = new Villa(null, 0);
		Bookable apartment1 = new Apartment(null, 0);

		Bookable[] accomodations = {hotel1,villa1,apartment1};

		AirbnbAPI a = new Airbnb(accomodations);

		System.out.println(a.findAccommodationById("HOT-1").getId());  
	}
}
