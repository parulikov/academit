package ru.parulikov.shape;

public class Square implements Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public int hashCode() {
        return 53 + (int) (Double.doubleToLongBits(side) - (Double.doubleToLongBits(side) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return side == ((Square) obj).side;
    }

    @Override
    public String toString() {
        return String.format("Class: %s%nSide: %s%nArea: %s%nPerimeter: %s%nHashCode: %s%n",
                this.getClass(), side, getArea(), getPerimeter(), Integer.toHexString(hashCode()));
    }
}
