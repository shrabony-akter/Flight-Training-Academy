package Mahin;

import java.io.Serializable;

public class GroundTheoryLesson implements Serializable {

    private String lessonTitle;
    private String topic;
    private String description;
    private String lessonDate;

    public GroundTheoryLesson(String lessonTitle,
                              String topic,
                              String description,
                              String lessonDate) {

        this.lessonTitle = lessonTitle;
        this.topic = topic;
        this.description = description;
        this.lessonDate = lessonDate;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }
}