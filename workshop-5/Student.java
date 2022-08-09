import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;
    public void setStdID(int stdID) {
        this.stdID = stdID;
    }
    public int getStdID() {
        return stdID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
    public ArrayList<String> getCourses() {
        return courses;
    }
    @Override
    public String toString() {
        return "Student ID: " + getStdID() + "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nCourses: " + getCourses() + "\n";
    }
    public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
        setStdID(stdID);
        setFirstName(firstName);
        setLastName(lastName);
        setCourses(courses);
    }
    public Student(){

    }
}
