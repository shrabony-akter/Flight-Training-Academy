package Shrabony;

import java.io.Serializable;

public class TrainingProgress implements Serializable {

    private String lessonName;
    private String trainingDate;
    private String instructorName;
    private double marks;
    private String completionStatus;

    public TrainingProgress(String lessonName,
                            String trainingDate,
                            String instructorName,
                            double marks,
                            String completionStatus) {

        this.lessonName = lessonName;
        this.trainingDate = trainingDate;
        this.instructorName = instructorName;
        this.marks = marks;
        this.completionStatus = completionStatus;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }
}