package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class StudentFeeRecordsM1 {
    private String student_id,name,course;
    private float fee,paid,due;
    private LocalDate date;

    public StudentFeeRecordsM1(String student_id, String name, String course, float fee, float paid, float due, LocalDate date) {
        this.student_id = student_id;
        this.name = name;
        this.course = course;
        this.fee = fee;
        this.paid = paid;
        this.due = due;
        this.date = date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StudentFeeRecordsM1{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", fee=" + fee +
                ", paid=" + paid +
                ", due=" + due +
                ", date=" + date +
                '}';
    }
}
