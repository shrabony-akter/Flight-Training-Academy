package Shrabony;

import java.io.Serializable;

public class LeaveRequest implements Serializable {

    private String leaveDate;
    private String leaveReason;
    private String requestStatus;

    public LeaveRequest(String leaveDate,
                        String leaveReason,
                        String requestStatus) {

        this.leaveDate = leaveDate;
        this.leaveReason = leaveReason;
        this.requestStatus = requestStatus;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}