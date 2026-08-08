package Mahin;

import java.io.Serializable;
import java.util.ArrayList;
import Utility.BinaryFileUtil;

public class Flight implements Serializable {

    private String flightId;
    private String flightTime;
    private String destination;
    private String status;
    private String altitude;
    private String speed;
    private String runway;

    public Flight(String flightId,
                  String flightTime,
                  String destination,
                  String status,
                  String altitude,
                  String speed,
                  String runway) {

        this.flightId = flightId;
        this.flightTime = flightTime;
        this.destination = destination;
        this.status = status;
        this.altitude = altitude;
        this.speed = speed;
        this.runway = runway;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRunway() {
        return runway;
    }

    public void setRunway(String runway) {
        this.runway = runway;
    }

    public static void initializeSampleFlights() {

        ArrayList<Flight> flights =
                BinaryFileUtil.readObjects("flights.dat");

        if (!flights.isEmpty()) {
            return;
        }

        flights.add(new Flight(
                "BG101",
                "10:00 AM",
                "Dhaka",
                "Active",
                "5000 ft",
                "Normal",
                "Not Assigned"
        ));

        flights.add(new Flight(
                "BG202",
                "12:30 PM",
                "Chittagong",
                "Scheduled",
                "0 ft",
                "Not Started",
                "Not Assigned"
        ));

        flights.add(new Flight(
                "BG303",
                "03:00 PM",
                "Sylhet",
                "Scheduled",
                "0 ft",
                "Not Started",
                "Not Assigned"
        ));

        BinaryFileUtil.saveList(
                "flights.dat",
                flights
        );
    }
}