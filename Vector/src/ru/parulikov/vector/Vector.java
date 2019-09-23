package ru.parulikov.vector;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        vector = new double[n];

        for (int i = 0; i < n; i++) {
            vector[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.vector = new double[vector.getSize()];

        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] = vector.getElement(i);
        }
    }

    public Vector(double[] doubleArray) {
        vector = new double[doubleArray.length];

        System.arraycopy(doubleArray, 0, vector, 0, doubleArray.length);
    }

    public Vector(int n, double[] doubleArray) {
        vector = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < doubleArray.length) {
                vector[i] = doubleArray[i];
            } else {
                vector[i] = 0;
            }
        }
    }

    public static Vector foldVectors(Vector vector1, Vector vector2) {
        int maxLength = vector1.getSize() > vector2.getSize() ? vector1.getSize() : vector2.getSize();

        Vector vector = new Vector(maxLength);

        for (int i = 0; i < maxLength; i++) {
            if (vector1.getSize() <= i) {
                vector.setElement(vector2.getElement(i), i);
            } else if (vector2.getSize() <= i) {
                vector.setElement(vector1.getElement(i), i);
            } else {
                vector.setElement(vector1.getElement(i) + vector2.getElement(i), i);
            }
        }

        return vector;
    }

    public static Vector deductVectors(Vector vector1, Vector vector2) {
        int maxLength = vector1.getSize() > vector2.getSize() ? vector1.getSize() : vector2.getSize();

        Vector vector = new Vector(maxLength);

        for (int i = 0; i < maxLength; i++) {
            if (vector1.getSize() <= i) {
                vector.setElement(vector2.getElement(i), i);
            } else if (vector2.getSize() <= i) {
                vector.setElement(vector1.getElement(i), i);
            } else {
                vector.setElement(vector1.getElement(i) - vector2.getElement(i), i);
            }
        }

        return vector;
    }

    public static double dotProduct(Vector vector1, Vector vector2) {
        int minLenght = vector1.getSize() < vector2.getSize() ? vector1.getSize() : vector2.getSize();

        double result = 0;

        for (int i = 0; i < minLenght; i++) {
            result += vector1.getElement(i) * vector2.getElement(i);
        }

        return result;
    }

    public int getSize() {
        return vector.length;
    }

    public double getElement(int index) {
        return vector[index];
    }

    public void setElement(double element, int index) {
        if (index >= vector.length) {
            throw new IllegalArgumentException(String.format("В векторе нет индекса %d", index));
        }

        vector[index] = element;
    }

    public void foldVector(Vector vector) {
        if (this.vector.length < vector.getSize()) {
            increaseVector(vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); i++) {
            this.vector[i] += vector.getElement(i);
        }
    }

    public void deductVector(Vector vector) {
        if (this.vector.length < vector.getSize()) {
            increaseVector(vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); i++) {
            this.vector[i] -= vector.getElement(i);
        }
    }

    public void dotProduct(double scalar) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= scalar;
        }
    }

    public void turnVector() {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= -1;
        }
    }

    private void increaseVector(int finalLength) {
        double[] vector = new double[finalLength];

        System.arraycopy(this.vector, 0, vector, 0, this.vector.length);

        this.vector = vector;
    }

    @Override
    public int hashCode() {
        int hashCode = 13;

        for (double d : vector) {
            hashCode += 53 + (int) (Double.doubleToLongBits(d) - (Double.doubleToLongBits(d) >>> 32));
        }

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

        if (vector.length != ((Vector) obj).getSize()) {
            return false;
        }

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != ((Vector) obj).getElement(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        if (vector.length != 0) {
            result.append(vector[0]);

            for (int i = 1; i < vector.length; i++) {
                result.append(", ");
                result.append(vector[i]);
            }
        }
        result.append("}");

        return result.toString();
    }
}
