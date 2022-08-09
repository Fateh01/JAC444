package Shapes;

public class Square extends Rectangle {
    public Square(double side){
        super(side, side);
    }

    Shapes shape = () -> getWidth() * getHeight();
    @Override
    public String toString(){
        return String.format("%s {s=%.1f} perimeter = %.4f units, area = %.4f sq units", this.getClass().getSimpleName(), getWidth(), perimeter(), shape.area());
    }
}
