package Mahin;

import java.io.Serializable;

public class FlightStatus implements Serializable {

    private String flightId;
    private String status;
    private String altitude;
    private String speed;

    public FlightStatus(String flightId,
                        String status,
                        String altitude,
                        String speed) {

        this.flightId = flightId;
        this.status = status;
        this.altitude = altitude;
        this.speed = speed;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
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
}