package Nadim_Hasan_Khan;

import java.time.LocalDate;

public class PrepareFinancialReportsM1 {
    private LocalDate date;
    private String description,type;
    private float amount,balance;

    public PrepareFinancialReportsM1(LocalDate date, String description, String type, float amount, float balance) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "PrepareFinancialReportsM1{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
