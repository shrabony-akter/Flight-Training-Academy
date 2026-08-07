package Shrabony;

import java.io.Serializable;

public class FlightSchedule implements Serializable {

    private String flightId;
    private String flightDate;
    private String flightTime;
    private String aircraftType;
    private String instructorName;

    public FlightSchedule(String flightId,
                          String flightDate,
                          String flightTime,
                          String aircraftType,
                          String instructorName) {

        this.flightId = flightId;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.aircraftType = aircraftType;
        this.instructorName = instructorName;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}