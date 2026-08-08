package Mahin;

import java.io.Serializable;

public class LandingRequest implements Serializable {

    private String flightId;
    private String requestDate;
    private String status;

    public LandingRequest(String flightId,
                          String requestDate,
                          String status) {

        this.flightId = flightId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}