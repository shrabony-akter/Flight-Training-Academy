package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class ProcessFeePaymentsM1 {
    private int payment_id;
    private String student,course,status;
    private float amount;
    private LocalDate date;

    public ProcessFeePaymentsM1(int payment_id, String student, String course, String status, float amount, LocalDate date) {
        this.payment_id = payment_id;
        this.student = student;
        this.course = course;
        this.status = status;
        this.amount = amount;
        this.date = date;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "ProcessFeePaymentsM1{" +
                "payment_id=" + payment_id +
                ", student='" + student + '\'' +
                ", course='" + course + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
