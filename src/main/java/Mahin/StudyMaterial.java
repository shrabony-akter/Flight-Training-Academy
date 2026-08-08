package Mahin;

import java.io.Serializable;

public class StudyMaterial implements Serializable {

    private String materialTitle;
    private String subject;
    private String description;
    private String fileName;

    public StudyMaterial(String materialTitle,
                         String subject,
                         String description,
                         String fileName) {

        this.materialTitle = materialTitle;
        this.subject = subject;
        this.description = description;
        this.fileName = fileName;
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}