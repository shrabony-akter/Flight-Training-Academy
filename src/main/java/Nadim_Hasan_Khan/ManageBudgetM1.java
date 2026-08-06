package Nadim_Hasan_Khan;

public class ManageBudgetM1 {
    private String department;
    private float allocated,spent,remaining;

    public ManageBudgetM1(String department, float allocated, float spent, float remaining) {
        this.department = department;
        this.allocated = allocated;
        this.spent = spent;
        this.remaining = remaining;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getAllocated() {
        return allocated;
    }

    public void setAllocated(float allocated) {
        this.allocated = allocated;
    }

    public float getSpent() {
        return spent;
    }

    public void setSpent(float spent) {
        this.spent = spent;
    }

    public float getRemaining() {
        return remaining;
    }

    public void setRemaining(float remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "ManageBudgetM1{" +
                "department='" + department + '\'' +
                ", allocated=" + allocated +
                ", spent=" + spent +
                ", remaining=" + remaining +
                '}';
    }
}
