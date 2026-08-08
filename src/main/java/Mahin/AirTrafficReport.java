package Mahin;

import java.io.Serializable;

public class AirTrafficReport implements Serializable {

    private String reportTitle;
    private String reportDate;
    private String reportDetails;

    public AirTrafficReport(String reportTitle,
                            String reportDate,
                            String reportDetails) {

        this.reportTitle = reportTitle;
        this.reportDate = reportDate;
        this.reportDetails = reportDetails;
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

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }
}