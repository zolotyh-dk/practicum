package sprint5.figure;

public class Square extends Rectangle {
    public Square(double a) {
        super(a, a);
    }

    @Override
    public double getArea() {
        return a * a;
    }
}