import java.io.*;
import java.util.ArrayList;

public class ReadStudent {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File("src/Student.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (students != null) {
                for (Student student : students) {
                    System.out.println(student.toString());
                }
            }
        }
    }
}