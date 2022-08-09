import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Student[] student = {
                new Student("Jack" , "Smith" , 50.0 , "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media"),
        };
        List<Student> students = Arrays.asList(student);

        //Task 6: Student names in order by last name then first name
        System.out.println("\nStudent names in order by last name then first:");
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
                .map(Student::getName)
                .forEach(System.out::println);

        //Task 7: Students by department
        Map<String, List<Student>> studentsByDepartment = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("\nStudents by department:");
        studentsByDepartment.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(student1 -> System.out.println("   " + student1));
        });

        //Task 8: Count of Students by department
        System.out.println("\nCount of Students by department:");
        studentsByDepartment.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s has %d student(s)\n", e.getKey(), e.getValue().size()));

        //Task 9: Sum of Students' grades
        double gradeSum = students.stream()
                .mapToDouble(Student::getGrade)
                .sum();
        System.out.printf("\nSum of Students' grades: %.2f\n", gradeSum);

        //Task 10: Average of Students' grades
        System.out.printf("\nAverage of Students' grades: %.2f\n", gradeSum / students.size());

    }

}
