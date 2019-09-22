package ru.parulikov.shape;

public class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int hashCode() {
        return 81 + (int) (Double.doubleToLongBits(radius) - (Double.doubleToLongBits(radius) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return radius == ((Circle) obj).radius;
    }

    @Override
    public String toString() {
        return String.format("Class: %s%nRadius: %s%nArea: %s%nPerimeter: %s%nHashCode: %s%n",
                this.getClass(), radius, getArea(), getPerimeter(), Integer.toHexString(hashCode()));
    }
}
