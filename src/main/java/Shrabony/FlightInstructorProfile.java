package Shrabony;

import java.io.Serializable;

public class FlightInstructorProfile implements Serializable {

    private String fullName;
    private String contactNumber;
    private String emailAddress;

    public FlightInstructorProfile(String fullName,
                                   String contactNumber,
                                   String emailAddress) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}