package Mahin;

import java.io.Serializable;

public class GroundTheoryAssessment implements Serializable {

    private String studentId;
    private String studentName;
    private String assessmentTitle;
    private String assessmentDate;
    private String totalMarks;
    private String obtainedMarks;
    private String remarks;

    public GroundTheoryAssessment(String studentId,
                                  String studentName,
                                  String assessmentTitle,
                                  String assessmentDate,
                                  String totalMarks,
                                  String obtainedMarks,
                                  String remarks) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.assessmentTitle = assessmentTitle;
        this.assessmentDate = assessmentDate;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        this.remarks = remarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(String obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}