import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Write {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 280);
        frame.getContentPane().setBackground(new Color(220, 220, 220));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel fNameLabel = new JLabel("First name");
        fNameLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        fNameLabel.setBounds(40, 20, 100, 30);
        panel.add(fNameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(35, 40, 170, 30);
        panel.add(nameField);

        JLabel lNameLabel = new JLabel("Last name");
        lNameLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        lNameLabel.setBounds(220, 20, 100, 30);
        panel.add(lNameLabel);

        JTextField lNameField = new JTextField();
        lNameField.setBounds(215, 40, 170, 30);
        panel.add(lNameField);

        JLabel idLabel= new JLabel("Student ID");
        idLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        idLabel.setBounds(40, 80, 100, 30);
        panel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(35, 100, 120, 30);
        panel.add(idField);

        JLabel courseLabel = new JLabel("Courses (comma separated)");
        courseLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        courseLabel.setBounds(170, 80, 200, 30);
        panel.add(courseLabel);

        JTextField courseField = new JTextField();
        courseField.setBounds(165, 100, 220, 30);
        panel.add(courseField);

        ArrayList<Student> students = new ArrayList<>();
        JButton submitButton = new JButton("Save Data");
        submitButton.setBounds(35, 150, 170, 34);
        panel.add(submitButton);
        submitButton.addActionListener(e -> {
            String fName = nameField.getText();
            String lName = lNameField.getText();
            String id = idField.getText();
            String courses = courseField.getText();
            ArrayList<String> list = new ArrayList<>(Arrays.asList(courses.split(",")));
            if (fName.isEmpty() || lName.isEmpty() || id.isEmpty() || courses.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Student student = new Student(id, fName, lName, list);
                    students.add(student);
                    File file = new File("src/Student.dat");
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(students);
                    oos.close();
                    System.out.println(fName + " " + lName + " " + id + " " + list);
                    JOptionPane.showMessageDialog(null, "Student added successfully!", "Success", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error adding student!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton clearForm = new JButton("Clear Form");
        clearForm.setBounds(215, 150, 170, 34);
        panel.add(clearForm);
        clearForm.addActionListener(e -> {
            nameField.setText("");
            lNameField.setText("");
            idField.setText("");
            courseField.setText("");
        });

        JButton viewButton = new JButton("Show Saved Data");
        viewButton.setBounds(35, 195, 350, 34);
        panel.add(viewButton);
        viewButton.addActionListener(e -> new Read());

        frame.add(panel);
        frame.validate();
        frame.setVisible(true);
    }
}
