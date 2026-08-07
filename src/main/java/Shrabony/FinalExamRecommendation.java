package Shrabony;

import java.io.Serializable;
import java.time.LocalDate;

public class FinalExamRecommendation implements Serializable {

    private String studentId;
    private String recommendationStatus;
    private String recommendationNote;
    private String recommendationDate;

    public FinalExamRecommendation(String studentId,
                                   String recommendationStatus,
                                   String recommendationNote,
                                   String recommendationDate) {

        this.studentId = studentId;
        this.recommendationStatus = recommendationStatus;
        this.recommendationNote = recommendationNote;
        this.recommendationDate = recommendationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRecommendationStatus() {
        return recommendationStatus;
    }

    public void setRecommendationStatus(String recommendationStatus) {
        this.recommendationStatus = recommendationStatus;
    }

    public String getRecommendationNote() {
        return recommendationNote;
    }

    public void setRecommendationNote(String recommendationNote) {
        this.recommendationNote = recommendationNote;
    }

    public String getRecommendationDate() {
        return recommendationDate;
    }

    public void setRecommendationDate(String recommendationDate) {
        this.recommendationDate = recommendationDate;
    }

    @Override
    public String toString() {
        return "FinalExamRecommendation{" +
                "studentId='" + studentId + '\'' +
                ", recommendationStatus='" + recommendationStatus + '\'' +
                ", recommendationNote='" + recommendationNote + '\'' +
                ", recommendationDate='" + recommendationDate + '\'' +
                '}';
    }
}