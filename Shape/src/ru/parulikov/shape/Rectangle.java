package ru.parulikov.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
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
        return 14 + (int) (Double.doubleToLongBits(width) - (Double.doubleToLongBits(width) >>> 32)) +
                (int) (Double.doubleToLongBits(height) - (Double.doubleToLongBits(height) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return width == ((Rectangle) obj).width && height == ((Rectangle) obj).height;
    }

    @Override
    public String toString() {
        return String.format("Class: %s%nWidth: %s%nHeight: %s%nArea: %s%nPerimeter: %s%nHashCode: %s%n",
                this.getClass(), width, height, getArea(), getPerimeter(), Integer.toHexString(hashCode()));
    }
}
