import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;
    public void setStdID(String stdID) {
        this.stdID = stdID;
    }
    public String getStdID() {
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
    public Student(String stdID, String firstName, String lastName, ArrayList<String> courses) {
        setStdID(stdID);
        setFirstName(firstName);
        setLastName(lastName);
        setCourses(courses);
    }

    public Student(){ }

    public void writeStudent(ArrayList<Student> students) {
        try {
            File file = new File("src/Student.dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (students.size() > 0) {
                System.out.println("\nAdded " + students.size() + " students successfully!");
            }
        }
    }
}
