package Shrabony;

import java.io.Serializable;

public class StudentPilotProfile implements Serializable {

    private String fullName;
    private String phoneNumber;
    private String emailAddress;

    public StudentPilotProfile(String fullName,
                               String phoneNumber,
                               String emailAddress) {

        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}