import ru.parulikov.shape.Shape;
import ru.parulikov.shape.ShapeFactory;
import ru.parulikov.shape.ShapesAreaComparator;
import ru.parulikov.shape.ShapesPerimeterComparator;

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
        System.out.println("-------------------");

        System.out.println("Shape with second perimeter");
        System.out.println(getNShapeByPerimeter(shapesArray, 1));
    }

    public static Shape getShapeWithMaxArea(Shape[] shapesArray) {
        //В данном методе нет смысла обрабатывать исключение, так как оно никогда не сгенерируется
        return getNShapeByArea(shapesArray, 0);
    }

    public static Shape getNShapeByArea(Shape[] shapeArray, int index) throws ArrayIndexOutOfBoundsException {
        return getNShapeByParameter(shapeArray, index, new ShapesAreaComparator());
    }

    public static Shape getShapeWithMaxPerimeter(Shape[] shapesArray) {
        return getNShapeByArea(shapesArray, 0);
    }

    public static Shape getNShapeByPerimeter(Shape[] shapeArray, int index) throws ArrayIndexOutOfBoundsException {
        return getNShapeByParameter(shapeArray, index, new ShapesPerimeterComparator());
    }

    private static Shape getNShapeByParameter
            (Shape[] shapeArray, int index, Comparator<Shape> comparator) throws ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс должен быть больше нуля");
        }

        if (index >= shapeArray.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за рамки массива");
        }

        Arrays.sort(shapeArray, comparator);

        return shapeArray[index];
    }
}
