package Shrabony;

import java.io.Serializable;

public class AdditionalSimulatorRequest implements Serializable {

    private String preferredDate;
    private String preferredTimeSlot;
    private String reason;
    private String requestStatus;

    public AdditionalSimulatorRequest(String preferredDate,
                                      String preferredTimeSlot,
                                      String reason,
                                      String requestStatus) {

        this.preferredDate = preferredDate;
        this.preferredTimeSlot = preferredTimeSlot;
        this.reason = reason;
        this.requestStatus = requestStatus;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getPreferredTimeSlot() {
        return preferredTimeSlot;
    }

    public void setPreferredTimeSlot(String preferredTimeSlot) {
        this.preferredTimeSlot = preferredTimeSlot;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}