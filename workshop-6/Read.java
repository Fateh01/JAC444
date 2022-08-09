import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Read {

    public String buildString(ArrayList<String> arr){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<arr.size(); i++){
            str.append(arr.get(i));
            if(i != arr.size()-1){
                str.append(", ");
            }
        }
        return str.toString();
    }
    Read() {

        ArrayList<Student> students;
        File file = new File("src/Student.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Student> finalStudents = students;

        JFrame frame = new JFrame("Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470, 370);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel fNameLabel = new JLabel("First name");
        fNameLabel.setBounds(40, 20, 400, 30);
        panel.add(fNameLabel);

        JTextField fNameField = new JTextField(finalStudents.get(0).getFirstName());
        fNameField.setBounds(35, 40, 400, 40);
        fNameField.setEditable(false);
        panel.add(fNameField);

        JLabel lNameLabel = new JLabel("Last name");
        lNameLabel.setBounds(40, 80, 400, 30);
        panel.add(lNameLabel);

        JTextField lNameField = new JTextField(finalStudents.get(0).getLastName());
        lNameField.setBounds(35, 100, 400, 40);
        lNameField.setEditable(false);
        panel.add(lNameField);

        JLabel idLabel = new JLabel("Student ID");
        idLabel.setBounds(40, 140, 400, 30);
        panel.add(idLabel);

        JTextField idField = new JTextField(finalStudents.get(0).getStdID());
        idField.setBounds(35, 160, 400, 40);
        idField.setEditable(false);
        panel.add(idField);

        JLabel courseLabel = new JLabel("Courses");
        courseLabel.setBounds(40, 200, 400, 30);
        panel.add(courseLabel);

        JTextField courseField = new JTextField(buildString(finalStudents.get(0).getCourses()));
        courseField.setBounds(35, 220, 400, 40);
        courseField.setEditable(false);
        panel.add(courseField);

        JButton next = new JButton("Next");
        next.setBounds(245, 280, 190, 34);


        final int[] index = {0};
        next.addActionListener(e -> {
            try {
                if (index[0] < finalStudents.size()) {
                    System.out.println(finalStudents.get(index[0]).toString());
                    fNameField.setText(finalStudents.get(index[0]).getFirstName());
                    lNameField.setText(finalStudents.get(index[0]).getLastName());
                    idField.setText(finalStudents.get(index[0]).getStdID());
                    courseField.setText(buildString(finalStudents.get(index[0]).getCourses()));
                    index[0]++;
                }
            } catch (IndexOutOfBoundsException e1) {
                JOptionPane.showMessageDialog(null, "No More Data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton previous = new JButton("Previous");
        previous.setBounds(35, 280, 190, 34);
        previous.addActionListener(e -> {
            try {
                if (index[0] > 0) {
                    index[0]--;
                    System.out.println(finalStudents.get(index[0]).toString());
                    fNameField.setText(finalStudents.get(index[0]).getFirstName());
                    lNameField.setText(finalStudents.get(index[0]).getLastName());
                    idField.setText(finalStudents.get(index[0]).getStdID());
                    courseField.setText(buildString(finalStudents.get(index[0]).getCourses()));
                }
            } catch (IndexOutOfBoundsException e1) {
                JOptionPane.showMessageDialog(null, "No Previous Data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(next);
        panel.add(previous);
        frame.add(panel);

        frame.validate();
        frame.setVisible(true);
    }
}