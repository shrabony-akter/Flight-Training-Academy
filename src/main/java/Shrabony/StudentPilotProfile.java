package Shrabony;

import Utility.BinaryFileUtil;

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

    public static void main (String[] args){
        StudentPilotProfile st1 = new StudentPilotProfile("st1","active","st1@gmail.com","01952593685","Shrabony");
        StudentPilotProfile st2 = new StudentPilotProfile("st2","inactive","st2@gmail.com","019552393685","Srity");
        StudentPilotProfile st3 = new StudentPilotProfile("st3","active","st3@gmail.com","01956393685","Arpa");
        StudentPilotProfile st4 = new StudentPilotProfile("st4","active","st4@gmail.com","01987593685","Riya");
        StudentPilotProfile st5 = new StudentPilotProfile("st5","inactive","st5@gmail.com","017823693685","Nadim");
        BinaryFileUtil.appendObject("data/studentPilotProfile.bin",st1);
        BinaryFileUtil.appendObject("data/studentPilotProfile.bin",st2);
        BinaryFileUtil.appendObject("data/studentPilotProfile.bin",st3);
        BinaryFileUtil.appendObject("data/studentPilotProfile.bin",st4);
        BinaryFileUtil.appendObject("data/studentPilotProfile.bin",st5);
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