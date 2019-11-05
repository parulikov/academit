package ru.parulikov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длинна массива должна быть больше нуля");
        }

        vector = new double[n];
    }

    public Vector(Vector copiedVector) {
        vector = Arrays.copyOf(copiedVector.vector, copiedVector.vector.length);
    }

    public Vector(double[] doubleArray) {
        if (doubleArray.length == 0) {
            throw new IllegalArgumentException("Длинна массива должна быть больше нуля");
        }

        vector = Arrays.copyOf(doubleArray, doubleArray.length);
    }

    public Vector(int n, double[] doubleArray) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длинна массива должна быть больше нуля");
        }

        vector = Arrays.copyOf(doubleArray, n);
    }

    public static Vector addition(Vector vector1, Vector vector2) {
        //Делаю копии чтобы не изменять оригинальные вектора
        Vector copyOfFistVector = new Vector(vector1);
        Vector copyOfSecondVector = new Vector(vector2);

        copyOfFistVector.addition(copyOfSecondVector);

        return copyOfFistVector;
    }

    public static Vector subtraction(Vector vector1, Vector vector2) {
        //Тоже самое
        Vector copyOfFistVector = new Vector(vector1);
        Vector copyOfSecondVector = new Vector(vector2);

        copyOfFistVector.subtraction(copyOfSecondVector);

        return copyOfFistVector;
    }

    public static double multiplication(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.getSize(), vector2.getSize());

        double result = 0;

        for (int i = 0; i < minLength; i++) {
            result += vector1.getElement(i) * vector2.getElement(i);
        }

        return result;
    }

    public int getSize() {
        return vector.length;
    }

    public double getElement(int index) {
        if (index < 0 || index >= vector.length) {
            throw new IndexOutOfBoundsException(String.format("В векторе нет индекса %d", index));
        }

        return vector[index];
    }

    public void setElement(int index, double element) {
        if (index < 0 || index >= vector.length) {
            throw new IndexOutOfBoundsException(String.format("В векторе нет индекса %d", index));
        }

        vector[index] = element;
    }

    public void addition(Vector addedVector) {
        if (vector.length < addedVector.getSize()) {
            vector = Arrays.copyOf(vector, addedVector.getSize());
        }

        for (int i = 0; i < addedVector.getSize(); i++) {
            vector[i] += addedVector.vector[i];
        }
    }

    public void subtraction(Vector deductibleVector) {
        if (vector.length < deductibleVector.getSize()) {
            vector = Arrays.copyOf(vector, deductibleVector.getSize());
        }

        for (int i = 0; i < deductibleVector.getSize(); i++) {
            vector[i] -= deductibleVector.vector[i];
        }
    }

    public void multiplicationByNumber(double scalar) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= scalar;
        }
    }

    public void turn() {
        multiplicationByNumber(-1);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Vector comparedVector = (Vector) obj;

        if (vector.length != comparedVector.getSize()) {
            return false;
        }

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != comparedVector.getElement(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        result.append(vector[0]);

        for (int i = 1; i < vector.length; i++) {
            result.append(", ");
            result.append(vector[i]);
        }

        result.append("}");

        return result.toString();
    }
}
