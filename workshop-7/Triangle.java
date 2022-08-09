package Shapes;

public class Triangle extends Rectangle {
    private double s3;
    public Triangle(double s1, double s2, double s3) {
        super(s1, s2);
        this.s3 = s3;
    }

    public double getS3() {
        return s3;
    }

    @Override
    public double perimeter() {
        return getWidth() + getHeight() + getS3();
    }

    @Override
    public String toString() {
        return String.format("%s {s1=%.1f, s2=%.1f, s3=%.1f} perimeter = %.4f units", this.getClass().getSimpleName(), getWidth(), getHeight(), s3, perimeter());
    }
}
