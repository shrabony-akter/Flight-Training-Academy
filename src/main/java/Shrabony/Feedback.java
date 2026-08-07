package Shrabony;

import java.io.Serializable;

public class Feedback implements Serializable {

    private String feedbackId;
    private String instructorName;
    private String feedbackDate;
    private String feedbackSummary;
    private String feedbackDetails;

    public Feedback(String feedbackId,
                    String instructorName,
                    String feedbackDate,
                    String feedbackSummary,
                    String feedbackDetails) {

        this.feedbackId = feedbackId;
        this.instructorName = instructorName;
        this.feedbackDate = feedbackDate;
        this.feedbackSummary = feedbackSummary;
        this.feedbackDetails = feedbackDetails;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(String feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getFeedbackSummary() {
        return feedbackSummary;
    }

    public void setFeedbackSummary(String feedbackSummary) {
        this.feedbackSummary = feedbackSummary;
    }

    public String getFeedbackDetails() {
        return feedbackDetails;
    }

    public void setFeedbackDetails(String feedbackDetails) {
        this.feedbackDetails = feedbackDetails;
    }
}
