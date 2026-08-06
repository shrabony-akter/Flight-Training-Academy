package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class IssueCertificateM1 {
    private int cert_no;
    private String student,program,status;
    private LocalDate date;

    public IssueCertificateM1(int cert_no, String student, String program, String status, LocalDate date) {
        this.cert_no = cert_no;
        this.student = student;
        this.program = program;
        this.status = status;
        this.date = date;
    }

    public int getCert_no() {
        return cert_no;
    }

    public void setCert_no(int cert_no) {
        this.cert_no = cert_no;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IssueCertificateM1{" +
                "cert_no=" + cert_no +
                ", student='" + student + '\'' +
                ", program='" + program + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
