package Shrabony;

import java.io.Serializable;

public class BookedSimulatorTraining implements Serializable {

    private String sessionDate;
    private String timeSlot;

    public BookedSimulatorTraining(String sessionDate, String timeSlot) {
        this.sessionDate = sessionDate;
        this.timeSlot = timeSlot;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}