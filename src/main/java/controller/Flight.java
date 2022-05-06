package controller;

import java.util.ArrayList;

import db.AppDB;
import handler.OutputHandler;

public class Flight {

	AppDB staticDB;
	OutputHandler outputHandler;

	public Flight() {
		staticDB = AppDB.getInstance();
	}

	public void storeAirlines(String flightCSV) {
		outputHandler = new OutputHandler(flightCSV, "", "");
		ArrayList<String> flightCatalog = outputHandler.TranslateFileData();

		for (String temp : flightCatalog) {
			if (temp == null)
				continue;

			String[] airlineInfo = temp.split(",");
			String category = airlineInfo[0], flightNumber = airlineInfo[1], seatNumber = airlineInfo[2],
					price = airlineInfo[3], arrivalCity = airlineInfo[4], departureCity = airlineInfo[5];

			staticDB.insertCategory(flightNumber, category, price, seatNumber);
			staticDB.buildFlight(flightNumber, arrivalCity, departureCity);

		}

	}

}
