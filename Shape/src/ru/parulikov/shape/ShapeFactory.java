package ru.parulikov.shape;

import java.util.Random;

public class ShapeFactory {
    private static final Random RANDOM = new Random();

    private ShapeFactory() {
    }

    public static Circle getCircle(double radius) {
        return new Circle(radius);
    }

    public static Circle getRandomCircle() {
        return new Circle(RANDOM.nextInt(50) + 1);
    }

    public static Square getSquare(double side) {
        return new Square(side);
    }

    public static Square getRandomSquare() {
        return new Square(RANDOM.nextInt(50) + 1);
    }

    public static Triangle getTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        return new Triangle(x1, y1, x2, y2, x3, y3);
    }

    public static Triangle getRandomTriangle() {
        return new Triangle(RANDOM.nextInt(100) - 50, RANDOM.nextInt(100) - 50,
                RANDOM.nextInt(100) - 50, RANDOM.nextInt(100) - 50,
                RANDOM.nextInt(100) - 50, RANDOM.nextInt(100) - 50);
    }

    public static Rectangle getRectangle(double width, double height) {
        return new Rectangle(width, height);
    }

    public static Rectangle getRandomRectangle() {
        return new Rectangle(RANDOM.nextInt(50) + 1, RANDOM.nextInt(50) + 1);
    }

    public static Shape getRandomShape() {
        switch (RANDOM.nextInt(4) + 1) {
            case 1:
                return getRandomCircle();
            case 2:
                return getRandomRectangle();
            case 3:
                return getRandomSquare();
            default:
                return getRandomTriangle();
        }
    }

    public static Shape[] getArrayOfRandomShapes(int count) {
        Shape[] shapesArray = new Shape[count];

        for (int i = 0; i < count; i++) {
            shapesArray[i] = getRandomShape();
        }

        return shapesArray;
    }
}
