package Mahin;

import java.io.Serializable;

public class StudentTrainingProgress implements Serializable {

    private String studentId;
    private String lesson;
    private String status;
    private String score;

    public StudentTrainingProgress(String studentId,
                                   String lesson,
                                   String status,
                                   String score) {

        this.studentId = studentId;
        this.lesson = lesson;
        this.status = status;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}