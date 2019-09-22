package ru.parulikov.shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
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
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) +
                Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2)) +
                Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
    }

    private double max(double a, double b) {
        return a > b ? a : b;
    }

    private double max(double a, double b, double c) {
        return max(a, b) > c ? max(a, b) : c;
    }

    private double min(double a, double b) {
        return a < b ? a : b;
    }

    private double min(double a, double b, double c) {
        return min(a, b) < c ? min(a, b) : c;
    }

    @Override
    public int hashCode() {
        int hashCode = 41;

        hashCode += 37 + (int) (Double.doubleToLongBits(x1) - (Double.doubleToLongBits(x1) >>> 32));
        hashCode += 37 + (int) (Double.doubleToLongBits(y1) - (Double.doubleToLongBits(y1) >>> 32));
        hashCode += 37 + (int) (Double.doubleToLongBits(x2) - (Double.doubleToLongBits(x2) >>> 32));
        hashCode += 37 + (int) (Double.doubleToLongBits(y2) - (Double.doubleToLongBits(y2) >>> 32));
        hashCode += 37 + (int) (Double.doubleToLongBits(x3) - (Double.doubleToLongBits(x3) >>> 32));
        hashCode += 37 + (int) (Double.doubleToLongBits(y3) - (Double.doubleToLongBits(y3) >>> 32));

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

        return x1 == ((Triangle) obj).x1 && y1 == ((Triangle) obj).y1 &&
                x2 == ((Triangle) obj).x2 && y2 == ((Triangle) obj).y2 &&
                x3 == ((Triangle) obj).x3 && y3 == ((Triangle) obj).y3;
    }

    @Override
    public String toString() {
        return String.format("Class: %s%nCoordinates: %s, %s; %s, %s; %s, %s;%nArea: %s%nPerimeter: %s%nHashCode: %s%n",
                this.getClass(), x1, y1, x2, y2, x3, y3, getArea(), getPerimeter(), Integer.toHexString(hashCode()));
    }
}
