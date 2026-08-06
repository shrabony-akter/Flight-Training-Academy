package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class ManageOutstandingM1 {
    private int student_id;
    private String name,course,status;
    private float total_due;
    private LocalDate last_pay;

    public ManageOutstandingM1(int student_id, String name, String course, String status, float total_due, LocalDate last_pay) {
        this.student_id = student_id;
        this.name = name;
        this.course = course;
        this.status = status;
        this.total_due = total_due;
        this.last_pay = last_pay;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal_due() {
        return total_due;
    }

    public void setTotal_due(float total_due) {
        this.total_due = total_due;
    }

    public LocalDate getLast_pay() {
        return last_pay;
    }

    public void setLast_pay(LocalDate last_pay) {
        this.last_pay = last_pay;
    }

    @Override
    public String toString() {
        return "ManageOutstandingM1{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", status='" + status + '\'' +
                ", total_due=" + total_due +
                ", last_pay=" + last_pay +
                '}';
    }
}
