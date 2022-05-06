package test;

import controller.Flight;
import controller.Reservation;

public class RunClient {
    public static void main(String[] args) {

            String flightCSV = args[1];
            String sampleCSV = args[0];
            String outputCSV = args[2];
            String outputTXT = args[3];

            Flight fl = new Flight();
            fl.storeAirlines(flightCSV);

            Reservation res_1 = new Reservation();
            res_1.translateReservationQuery(sampleCSV, outputCSV, outputTXT);


    }
}
