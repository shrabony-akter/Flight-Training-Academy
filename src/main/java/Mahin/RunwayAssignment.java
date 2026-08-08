package Mahin;

import java.io.Serializable;

public class RunwayAssignment implements Serializable {

    private String flightId;
    private String runway;
    private String assignmentDate;

    public RunwayAssignment(String flightId,
                            String runway,
                            String assignmentDate) {

        this.flightId = flightId;
        this.runway = runway;
        this.assignmentDate = assignmentDate;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getRunway() {
        return runway;
    }

    public void setRunway(String runway) {
        this.runway = runway;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }
}