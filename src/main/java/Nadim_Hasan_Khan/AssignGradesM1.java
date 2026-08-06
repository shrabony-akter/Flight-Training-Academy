package Nadim_Hasan_Khan;

public class AssignGradesM1 {
    private int student_id,theory,practical,viva,total;
    private String name,grade;

    public AssignGradesM1(int student_id, int theory, int practical, int viva, int total, String name, String grade) {
        this.student_id = student_id;
        this.theory = theory;
        this.practical = practical;
        this.viva = viva;
        this.total = total;
        this.name = name;
        this.grade = grade;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }

    public int getViva() {
        return viva;
    }

    public void setViva(int viva) {
        this.viva = viva;
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

    @Override
    public String toString() {
        return "AssignGradesM1{" +
                "student_id=" + student_id +
                ", theory=" + theory +
                ", practical=" + practical +
                ", viva=" + viva +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
