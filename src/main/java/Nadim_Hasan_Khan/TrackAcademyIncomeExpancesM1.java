package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class TrackAcademyIncomeExpancesM1 {
    private LocalDate date;
    private float amount;
    private String type,remarks;

    public TrackAcademyIncomeExpancesM1(LocalDate date, float amount, String type, String remarks) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.remarks = remarks;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "TrackAcademyIncomeExpancesM1{" +
                "date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
