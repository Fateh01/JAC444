import java.util.Objects;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    public Student (String firstName, String lastName, double grade, String department) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setDepartment(department);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-10.2f%-10s", getFirstName(), getLastName(), getGrade(), getDepartment());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(this.firstName, student.firstName) && Objects.equals(this.lastName, student.lastName) && Double.compare(student.grade, this.grade) == 0 && Objects.equals(this.department, student.department);
    }

    @Override
    public int compareTo(Student o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }
}
