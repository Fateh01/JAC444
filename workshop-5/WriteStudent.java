import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteStudent {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        char quit;
        do {
            Student student = new Student();
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            student.setStdID(scan.nextInt());
            System.out.print("Enter first name: ");
            student.setFirstName(scan.next());
            System.out.print("Enter last name: ");
            student.setLastName(scan.next());
            ArrayList<String> courses = new ArrayList<>();
            System.out.print("Enter number of courses: ");
            int numCourses = scan.nextInt();
            for (int i = 0; i < numCourses; i++) {
                System.out.print("Enter course: ");
                courses.add(scan.next());
            }
            student.setCourses(courses);
            System.out.print("Press 'q' to save existing information/ press any other key to add another student: ");
            quit = scan.next().charAt(0);
            students.add(student);
        } while (quit != 'q');
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
