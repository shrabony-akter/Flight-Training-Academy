package Mahin;

import java.io.Serializable;

public class GroundTrainingReport implements Serializable {

    private String instructorName;
    private String reportTitle;
    private String reportDate;
    private String trainingSummary;
    private String studentProgress;
    private String remarks;

    public GroundTrainingReport(String instructorName,
                                String reportTitle,
                                String reportDate,
                                String trainingSummary,
                                String studentProgress,
                                String remarks) {

        this.instructorName = instructorName;
        this.reportTitle = reportTitle;
        this.reportDate = reportDate;
        this.trainingSummary = trainingSummary;
        this.studentProgress = studentProgress;
        this.remarks = remarks;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getTrainingSummary() {
        return trainingSummary;
    }

    public void setTrainingSummary(String trainingSummary) {
        this.trainingSummary = trainingSummary;
    }

    public String getStudentProgress() {
        return studentProgress;
    }

    public void setStudentProgress(String studentProgress) {
        this.studentProgress = studentProgress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
