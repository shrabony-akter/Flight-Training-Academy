package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class StudentAssesmentRecordM1 {
    private LocalDate date;
    private int Score;
    private String course,exam_type,grade,status;

    public StudentAssesmentRecordM1(LocalDate date, int score, String course, String exam_type, String grade, String status) {
        this.date = date;
        Score = score;
        this.course = course;
        this.exam_type = exam_type;
        this.grade = grade;
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentAssesmentM1{" +
                "date=" + date +
                ", Score=" + Score +
                ", course='" + course + '\'' +
                ", exam_type='" + exam_type + '\'' +
                ", grade='" + grade + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
