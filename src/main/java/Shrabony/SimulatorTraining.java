package Shrabony;

import java.io.Serializable;

public class SimulatorTraining implements Serializable {

    private String timeSlot;

    public SimulatorTraining(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return timeSlot;
    }
}