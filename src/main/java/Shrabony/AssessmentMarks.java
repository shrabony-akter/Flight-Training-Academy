package Shrabony;

import java.io.Serializable;

public class AssessmentMarks implements Serializable {

    private String studentId;
    private double marks;

    public AssessmentMarks(String studentId, double marks) {
        this.studentId = studentId;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "AssessmentMarks{" +
                "studentId='" + studentId + '\'' +
                ", marks=" + marks +
                '}';
    }
}