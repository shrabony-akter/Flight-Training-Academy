package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class EvaluatePerformanceM1 {
    private String name,course;
    private int id,score;
    private LocalDate exam_date;

    public EvaluatePerformanceM1(String name, String course, int id, int score, LocalDate exam_date) {
        this.name = name;
        this.course = course;
        this.id = id;
        this.score = score;
        this.exam_date = exam_date;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDate getExam_date() {
        return exam_date;
    }

    public void setExam_date(LocalDate exam_date) {
        this.exam_date = exam_date;
    }

    @Override
    public String toString() {
        return "EvaluatePerformanceM1{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", id=" + id +
                ", score=" + score +
                ", exam_date=" + exam_date +
                '}';
    }
}
