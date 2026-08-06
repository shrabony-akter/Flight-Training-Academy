package Nadim_Hasan_Khan;

import java.io.Serializable;
import java.time.LocalDate;

public class ApproveStudentPaymentRequestM1 implements Serializable {
    private int request_id;
    private String student,course;
    private float amount;
    private LocalDate date;

    public ApproveStudentPaymentRequestM1(int request_id, String student, String course, float amount, LocalDate date) {
        this.request_id = request_id;
        this.student = student;
        this.course = course;
        this.amount = amount;
        this.date = date;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ApproveStudentPaymentRequestM1{" +
                "request_id=" + request_id +
                ", student='" + student + '\'' +
                ", course='" + course + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
