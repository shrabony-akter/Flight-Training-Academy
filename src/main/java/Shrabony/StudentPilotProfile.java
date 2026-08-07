package Shrabony;

import java.io.Serializable;

public class StudentPilotProfile implements Serializable {

    private String studentId;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;
    private String trainingStatus;

    public StudentPilotProfile(String fullName,
                               String phoneNumber,
                               String emailAddress) {

        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public StudentPilotProfile(String studentId, String trainingStatus, String emailAddress, String phoneNumber, String fullName) {
        this.studentId = studentId;
        this.trainingStatus = trainingStatus;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
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