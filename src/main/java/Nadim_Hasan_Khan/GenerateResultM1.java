package Nadim_Hasan_Khan;

public class GenerateResultM1 {
    private int student_id, total;
    private String name, grade, position, status;

    public GenerateResultM1(int student_id, int total, String name, String grade, String position, String status) {
        this.student_id = student_id;
        this.total = total;
        this.name = name;
        this.grade = grade;
        this.position = position;
        this.status = status;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GenerateResultM1{" +
                "student_id=" + student_id +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", position='" + position + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

