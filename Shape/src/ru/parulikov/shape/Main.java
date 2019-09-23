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
        //В данном методе нет смысла обрабатывать исключение, так как оно никогда не сгенерируется
        return getNShapeByArea(shapesArray, 0);
    }

    public static Shape getNShapeByArea(Shape[] shapeArray, int index) throws IllegalArgumentException{
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть больше нуля");
        } else if (index >= shapeArray.length) {
            throw new IllegalArgumentException("Индекс выходит за рамки массива");
        }

        Arrays.sort(shapeArray, (o1, o2) -> Double.compare(o2.getArea(), o1.getArea()));

        return shapeArray[index];
    }
}
