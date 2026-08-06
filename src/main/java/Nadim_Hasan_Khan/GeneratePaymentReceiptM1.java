package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class GeneratePaymentReceiptM1 {
    private int receipt_id,student_id;
    private String student_name,student_label;
    private LocalDate date;

    public GeneratePaymentReceiptM1(int receipt_id, int student_id, String student_name, String student_label, LocalDate date) {
        this.receipt_id = receipt_id;
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_label = student_label;
        this.date = date;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_label() {
        return student_label;
    }

    public void setStudent_label(String student_label) {
        this.student_label = student_label;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GeneratePaymentReceiptM1{" +
                "receipt_id=" + receipt_id +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_label='" + student_label + '\'' +
                ", date=" + date +
                '}';
    }
}
