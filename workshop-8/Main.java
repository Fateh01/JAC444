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

        //Task 1: Display all students in the list
        System.out.println("Complete Student List:");
        students.forEach(System.out::println);

        //Task 2: Filter the list by grade (50.0 or higher)
        System.out.println("\nStudents who got 50.0-100.0 sorted by grade:");
        students.stream()
                .filter(s -> s.getGrade() >= 50.0)
                .sorted(GRADE_COMPARATOR)
                .forEach(System.out::println);

        //Task 3: First Student who got 50.0-100.0
        System.out.println("\nFirst student who got 50.0-100.0:");
        students.stream()
                .filter(s -> s.getGrade() >= 50.0)
                .findFirst()
                .ifPresent(System.out::println);

        //Task 4a: Students in ascending order by last name then first name
        System.out.println("\nStudents in ascending order by last name then first:");
        students.stream()
                .sorted(LAST_NAME_ASCENDING)
                .forEach(System.out::println);

        //Task 4b: Students in descending order by last name then first name
        System.out.println("\nStudents in descending order by last name then first:");
        students.stream()
                .sorted(LAST_NAME_DESCENDING)
                .forEach(System.out::println);

        //Task 5: Unique Student last names
        System.out.println("\nUnique Student last names:");
        students.stream()
                .sorted(LAST_NAME_ASCENDING)
                .map(Student::getLastName)
                .distinct()
                .forEach(System.out::println);

        //Task 6: Student names in order by last name then first name
        System.out.println("\nStudent names in order by last name then first:");
        students.stream()
                .sorted(LAST_NAME_DESCENDING)
                .map(Student::getName)
                .forEach(System.out::println);

        //Task 7: Students by department
        Map<String, List<Student>> studentsByDepartment = students.stream()
                .collect(Collectors
                         .groupingBy(Student::getDepartment));
        System.out.println("\nStudents by department:");
        studentsByDepartment.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });

        //Task 8: Count of Students by department
        System.out.println("\nCount of Students by department:");
        studentsByDepartment.forEach((k, v) -> System.out.printf("%s has %d student(s)\n", k, v.size()));

        //Task 9: Sum of Students' grades
        double gradeSum = students.stream()
                .mapToDouble(Student::getGrade)
                .sum();
        System.out.printf("\nSum of Students' grades: %.2f\n", gradeSum);

        //Task 10: Average of Students' grades
        double gradeAverage = gradeSum / students.size();
        System.out.printf("\nAverage of Students' grades: %.2f", gradeAverage);

    }

    public static final Comparator<Student> GRADE_COMPARATOR = (o1, o2) -> {
        if (o1.getGrade() == o2.getGrade()) return 0;
        return o1.getGrade() > o2.getGrade() ? 1 : -1;
    };

    public static final Comparator<Student> LAST_NAME_ASCENDING = (o1, o2) -> {
        int result = o1.getLastName().compareTo(o2.getLastName());
        if (result == 0) return o1.getFirstName().compareTo(o2.getFirstName());
        return result;
    };

    public static final Comparator<Student> LAST_NAME_DESCENDING = (o1, o2) -> -LAST_NAME_ASCENDING.compare(o1, o2);
}
