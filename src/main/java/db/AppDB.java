package db;
import java.util.HashMap;
import type.Category;
import model.CategoryFactory;

public class AppDB {
	private static AppDB staticDB;
	private HashMap<String,HashMap<String,Category>> seatCategories;
	private HashMap<String, HashMap<String, String>> details;

	private AppDB() {
		seatCategories = new HashMap<String,HashMap<String,Category>>();
		details = new HashMap<String, HashMap<String, String>>();
	}

	public static AppDB getInstance() {
		if(staticDB == null) {
			staticDB = new AppDB();
		}
		return staticDB;
	}

	public void insertCategory(String flightNumber, String category, String price, String seatNumber) {
		HashMap<String, Category> categoryOutline;

		if(seatCategories.containsKey(flightNumber)) {
			categoryOutline = seatCategories.get(flightNumber);
		} else {
			categoryOutline = new HashMap<String,Category>();
			seatCategories.put(flightNumber, categoryOutline);
		}

		if(!categoryOutline.containsKey(category)) {
			Category obj = new CategoryFactory().create(category);
			obj.setPrice(Integer.parseInt(price));
			obj.setSeatCount(Integer.parseInt(seatNumber));
			if(obj != null) {
				categoryOutline.put(category, obj);
			}
		}

	}

	public void buildFlight(String flightNumber, String arrival, String departure) {
		HashMap<String, String> flightInfo;

		if (details.containsKey(flightNumber)) {
			flightInfo = details.get(flightNumber);
		} else {
			flightInfo = new HashMap<String, String>();
			details.put(flightNumber, flightInfo);
		}

		flightInfo.put("ARRIVAL CITY: ", arrival);
		flightInfo.put("DEPARTURE CITY: ", departure);
	}

	public boolean isAuthenticflightNumber(String flightNumber) {
		return staticDB.details.containsKey(flightNumber);
	}

	public boolean isAuthenticCounter(String flightNumber, String category, int seatNum) {
		try {
			Category obj = getObj(flightNumber, category);
			if(obj == null) {
				return false;
			}
			int availableSeats = obj.getSeatCount();
			return seatNum <= availableSeats;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private Category getObj(String flightNumber, String category) {
		if(!isAuthenticflightNumber(flightNumber)) {
			return null;
		}
		HashMap<String,Category> categoryMap = staticDB.seatCategories.get(flightNumber);
		if(!categoryMap.containsKey(category))
			return null;

		return categoryMap.get(category);
	}


	public void amendCounter(String flightNumber, String category, int requestedSeats) {
		Category obj = getObj(flightNumber, category);
		if(obj != null) {
			int availableSeats = obj.getSeatCount();
			obj.setSeatCount(availableSeats - requestedSeats);
		}
	}

	public Integer getPrice(String flightNumber, String category) {
		Category obj = getObj(flightNumber, category);
		if(obj != null) {
			return obj.getPrice();
		}
		return 0;
	}

}
