package sprint4;

public class Practicum {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        Ellipse ellipse = new Ellipse();

        circle.drawCircle();
        square.drawSquare();
        rectangle.drawRectangle();
        ellipse.drawCircle();
        ellipse.circleToEllipse();
    }
}

class Figure {
    public void drawCircle() {
        System.out.println("Рисуем круг");
    }

    public void drawSquare() {
        System.out.println("Рисуем квадрат");
    }

    public void drawRectangle() {
        System.out.println("Рисуем прямоугольник");
    }
}

class Circle extends Figure {
}

class Square extends Figure {
}

class Rectangle extends Figure {
}

class Ellipse extends Circle {
    public void circleToEllipse() {
        System.out.println("Превращаем круг в овал");
    }
}
