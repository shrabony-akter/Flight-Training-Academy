package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class ConductExamsM1 {
    private int student_id,exam_id;
    private LocalDate date;
    private String course,time;

    public ConductExamsM1(int student_id, int exam_id, LocalDate date, String course, String time) {
        this.student_id = student_id;
        this.exam_id = exam_id;
        this.date = date;
        this.course = course;
        this.time = time;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ConductExamsM1{" +
                "student_id=" + student_id +
                ", exam_id=" + exam_id +
                ", date=" + date +
                ", course='" + course + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
