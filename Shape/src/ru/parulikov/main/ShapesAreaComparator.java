package ru.parulikov.main;

import ru.parulikov.shape.Shape;

import java.util.Comparator;

public class ShapesAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o2.getArea(), o1.getArea());
    }
}
