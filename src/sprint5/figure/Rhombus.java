package sprint5.figure;

public class Rhombus extends Parallelogram {
    // Высота ромба
    private final double h;

    public Rhombus(double a, double h) {
        super(a);
        this.h = h;
    }

    @Override
    public double getArea() {
        return a * h;
    }
}