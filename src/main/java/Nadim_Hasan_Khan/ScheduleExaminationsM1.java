package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class ScheduleExaminationsM1 {
    private String course,exam_type,time,duration;
    private LocalDate exam_date;
    private int total_marks;

    public ScheduleExaminationsM1(String course, String exam_type, String time, String duration, LocalDate exam_date, int total_marks) {
        this.course = course;
        this.exam_type = exam_type;
        this.time = time;
        this.duration = duration;
        this.exam_date = exam_date;
        this.total_marks = total_marks;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getExam_date() {
        return exam_date;
    }

    public void setExam_date(LocalDate exam_date) {
        this.exam_date = exam_date;
    }

    public int getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(int total_marks) {
        this.total_marks = total_marks;
    }

    @Override
    public String toString() {
        return "ScheduleExaminationsM1{" +
                "course='" + course + '\'' +
                ", exam_type='" + exam_type + '\'' +
                ", time='" + time + '\'' +
                ", duration='" + duration + '\'' +
                ", exam_date=" + exam_date +
                ", total_marks=" + total_marks +
                '}';
    }
}
