package Shrabony;

import java.io.Serializable;

public class AdditionalSimulatorRequest implements Serializable {

    private String requestId;
    private String studentId;
    private String preferredDate;
    private String preferredTimeSlot;
    private String reason;
    private String requestStatus;

    public AdditionalSimulatorRequest(String requestId,
                                      String studentId,
                                      String preferredDate,
                                      String preferredTimeSlot,
                                      String reason,
                                      String requestStatus) {

        this.requestId = requestId;
        this.studentId = studentId;
        this.preferredDate = preferredDate;
        this.preferredTimeSlot = preferredTimeSlot;
        this.reason = reason;
        this.requestStatus = requestStatus;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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