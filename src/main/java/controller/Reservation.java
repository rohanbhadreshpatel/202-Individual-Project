package controller;
import java.util.ArrayList;

import db.AppDB;
import handler.OutputHandler;
import validation.ChainValidate;

public class Reservation {
	
	ArrayList<String> reason = new ArrayList<String>();
	ArrayList<String> impetus = new ArrayList<String>();
	
	public void translateReservationQuery(String sampleCSV, String outputCSV, String outputTXT) {
		try {
			OutputHandler outputHandler = new OutputHandler(sampleCSV, outputCSV, outputTXT);
			ArrayList<String> reservationQuery = outputHandler.TranslateFileData();
			for(String tempQuery: reservationQuery) {
				if(tempQuery == null)
					continue;
				String[] queryArr = tempQuery.split(",");
				String reservationName = queryArr[0], flightNumber = queryArr[1], category = queryArr[2],
						 cardNumber = queryArr[4];
				int numberOfSeats = Integer.parseInt(queryArr[3]);
				authReservation(reservationName, flightNumber, category, numberOfSeats, cardNumber);
			}
			outputHandler.generateOutput(impetus);
			outputHandler.generateTXT(reason);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean authReservation(String reservationName, String flightNumber, String category, int numberOfSeats, String cardNumber) {
		AppDB staticDB = AppDB.getInstance();
		String reasonAlert = "PLEASE PROVIDE VALID RESERVATION DETAILS for " + reservationName + ": ";
		if(!staticDB.isAuthenticflightNumber(flightNumber)) {
			reasonAlert += "INVALID FLIGHT NUMBER"; 
			reason.add(reasonAlert);
			return false;
		}
		
		if(!staticDB.isAuthenticCounter(flightNumber, category, numberOfSeats)) {
			reasonAlert += "INVALID SEAT NUMBER";
			reason.add(reasonAlert);
			return false;
		}
		
		ChainValidate cardValidationChain = new ChainValidate();
		if(!cardValidationChain.auth(cardNumber)) {
			reasonAlert += "INVALID CARD NUMBER";
			reason.add(reasonAlert);
			return false;
		}
		
		int totalPrice = numberOfSeats * staticDB.getPrice(flightNumber, category);
		staticDB.amendCounter(flightNumber, category, numberOfSeats);
		
		impetus.add(reservationName+","+flightNumber+","+category+","+numberOfSeats+","+totalPrice);
		
		return true;
	}
}
