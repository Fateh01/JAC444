package Shapes;
import java.io.*;
import java.util.*;

public class Main {
    public static List<Shapes> read(String fileName) {
        File file = new File(fileName);
        List<Shapes> shapes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                List<String> tokens = List.of(str.split(","));
                switch (tokens.get(0)) {
                    case "Square" -> {
                        double side = Double.parseDouble(tokens.get(1));
                        if (side > 0) {
                            shapes.add(new Square(side));
                        }
                    }
                    case "Rectangle" -> {
                        double width = Double.parseDouble(tokens.get(1));
                        double height = Double.parseDouble(tokens.get(2));
                        if (width > 0 && height > 0) {
                            shapes.add(new Rectangle(width, height));
                        }
                    }
                    case "Circle" -> {
                        double radius = Double.parseDouble(tokens.get(1));
                        if (radius > 0) {
                            shapes.add(new Circle(radius));
                        }
                    }
                    case "Parallelogram" -> {
                        double width = Double.parseDouble(tokens.get(1));
                        double height = Double.parseDouble(tokens.get(2));
                        if (width > 0 && height > 0) {
                            shapes.add(new Parallelogram(width, height));
                        }
                    }
                    case "Triangle" -> {
                        double s1 = Double.parseDouble(tokens.get(1));
                        double s2 = Double.parseDouble(tokens.get(2));
                        double s3 = Double.parseDouble(tokens.get(3));
                        if (s1 > 0 && s2 > 0 && s3 > 0) {
                            shapes.add(new Triangle(s1, s2, s3));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return shapes;
    }

    public static void main(String[] args) {
        List<Shapes> shapes = read("shapes.txt");
        for (Shapes shape : shapes) {
                System.out.println(shape);

        }
    }
}