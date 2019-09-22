package ru.parulikov.shape;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapesArray = ShapeFactory.getArrayOfRandomShapes(10);

        System.out.println("All shapes in array:");
        System.out.println();
        for (Shape shape : shapesArray) {
            System.out.println(shape);
            System.out.println("-------------------");
        }
        System.out.println("-------------------");

        System.out.println("Shape with max area");
        System.out.println(getShapeWithMaxArea(shapesArray));
    }

    public static Shape getShapeWithMaxArea(Shape[] shapesArray) {
        return getNShapeByArea(shapesArray, 0);
    }

    public static Shape getNShapeByArea(Shape[] shapeArray, int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= shapeArray.length) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(shapeArray, (o1, o2) -> Double.compare(o2.getArea(), o1.getArea()));

        return shapeArray[index];
    }
}
