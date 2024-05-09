package sprint5.figure;

public class Rectangle extends Parallelogram {
    private final double b;

    public Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }
}