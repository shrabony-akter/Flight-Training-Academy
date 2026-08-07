package Shrabony;

import java.io.Serializable;

public class AssignedLesson implements Serializable {

    private String studentId;
    private String lessonName;

    public AssignedLesson(String studentId, String lessonName) {
        this.studentId = studentId;
        this.lessonName = lessonName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "AssignedLesson{" +
                "studentId='" + studentId + '\'' +
                ", lessonName='" + lessonName + '\'' +
                '}';
    }
}