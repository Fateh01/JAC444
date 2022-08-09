package Shapes;

public class Rectangle implements Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        setWidth(width);
        setHeight(height);
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double length) {
        this.height = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double perimeter(){
        return 2 * (width + height);
    }

    Shapes shape = () -> getWidth() * getHeight();

    @Override
    public String toString(){
        return String.format("%s {w=%.1f, h=%.1f} perimeter = %.4f units, area = %.4f sq units", this.getClass().getSimpleName(), getWidth(), getHeight(), perimeter(), shape.area());
    }

    @Override
    public double area() {
        return 0;
    }
}