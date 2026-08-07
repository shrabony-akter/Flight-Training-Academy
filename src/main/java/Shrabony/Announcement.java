package Shrabony;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {

    private String announcementId;
    private String title;
    private String details;
    private String publishDate;

    public Announcement(String announcementId,
                        String title,
                        String details,
                        String publishDate) {

        this.announcementId = announcementId;
        this.title = title;
        this.details = details;
        this.publishDate = publishDate;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId='" + announcementId + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}