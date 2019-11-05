package ru.parulikov.shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return max(x1, x2, x3) - min(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return max(y1, y2, y3) - min(y1, y2, y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        return getSegmentLength(x1, y1, x2, y2) + getSegmentLength(x2, y2, x3, y3) + getSegmentLength(x3, y3, x1, y1);
    }

    private double getSegmentLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private double max(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }

    private double min(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }

    @Override
    public int hashCode() {
        int hashCode = 41;

        hashCode += 37 + Double.hashCode(x1);
        hashCode += 37 + Double.hashCode(y1);
        hashCode += 37 + Double.hashCode(x2);
        hashCode += 37 + Double.hashCode(y2);
        hashCode += 37 + Double.hashCode(x3);
        hashCode += 37 + Double.hashCode(y3);

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) obj;

        return x1 == triangle.x1 && y1 == triangle.y1 &&
                x2 == triangle.x2 && y2 == triangle.y2 &&
                x3 == triangle.x3 && y3 == triangle.y3;
    }

    @Override
    public String toString() {
        return String.format("Class: %s%nCoordinates: %s, %s; %s, %s; %s, %s;%nArea: %s%nPerimeter: %s%nHashCode: %s%n",
                this.getClass(), x1, y1, x2, y2, x3, y3, getArea(), getPerimeter(), Integer.toHexString(hashCode()));
    }
}
