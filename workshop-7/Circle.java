package Shapes;

public class Circle extends Square {
    public Circle(double radius) {
        super(radius);
    }

    Shapes shape = () -> Math.PI * Math.pow(getWidth(), 2);

    @Override
    public double perimeter() {
        return 2 * Math.PI * getWidth();
    }

    @Override
    public String toString(){
        return String.format("%s {r=%.1f} perimeter = %.4f units, area = %.4f sq units", this.getClass().getSimpleName(), getWidth(), perimeter(), shape.area());
    }
}
