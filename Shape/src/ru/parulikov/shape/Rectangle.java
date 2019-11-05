package ru.parulikov.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public int hashCode() {
        return 14 + Double.hashCode(width) + Double.hashCode(height);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;

        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public String toString() {
        return String.format("Class: %s%nWidth: %s%nHeight: %s%nArea: %s%nPerimeter: %s%nHashCode: %s%n",
                this.getClass(), width, height, getArea(), getPerimeter(), Integer.toHexString(hashCode()));
    }
}
