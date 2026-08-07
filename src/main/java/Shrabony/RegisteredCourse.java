package Shrabony;

import java.io.Serializable;

public class RegisteredCourse implements Serializable {

    private String studentId;
    private String courseName;

    public RegisteredCourse(String studentId, String courseName) {
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}