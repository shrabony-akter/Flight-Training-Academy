package Nadim_Hasan_Khan;

import java.io.Serializable;

public class ApproveCertificatonEligibalityM1 implements Serializable {
    private int student_id,attendance , credit;
    private String name , project , eligible , action;
    private float cgpa;

    public ApproveCertificatonEligibalityM1(int student_id, int attendance, int credit, String name, String project, String eligible, String action, float cgpa) {
        this.student_id = student_id;
        this.attendance = attendance;
        this.credit = credit;
        this.name = name;
        this.project = project;
        this.eligible = eligible;
        this.action = action;
        this.cgpa = cgpa;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getEligible() {
        return eligible;
    }

    public void setEligible(String eligible) {
        this.eligible = eligible;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "ApproveCertificatonEligibalityM1{" +
                "student_id=" + student_id +
                ", attendance=" + attendance +
                ", credit=" + credit +
                ", name='" + name + '\'' +
                ", project='" + project + '\'' +
                ", eligible='" + eligible + '\'' +
                ", action='" + action + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
