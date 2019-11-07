package ru.parulikov.matrix;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("Некорректный аргумент");
        }

        matrix = new Vector[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix copiedMatrix) {
        if (copiedMatrix == null) {
            throw new IllegalArgumentException("Некорректный аргумент");
        }

        matrix = new Vector[copiedMatrix.matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Vector(copiedMatrix.getLine(i));
        }
    }

    public Matrix(double[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException("Некорректный аргумент");
        }

        matrix = new Vector[array.length];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        if (vectorArray == null || vectorArray.length == 0) {
            throw new IllegalArgumentException("Некорректный аргумент");
        }

        matrix = new Vector[vectorArray.length];
        int maxVectorLength = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (vectorArray[i].getSize() > maxVectorLength) {
                maxVectorLength = vectorArray[i].getSize();
            }

            matrix[i] = new Vector(vectorArray[i]);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].getSize() < maxVectorLength) {
                matrix[i].increaseVector(maxVectorLength);
            }
        }
    }

    public int[] getMatrixSize() {
        return new int[]{matrix.length, matrix[0].getSize()};
    }

    public Vector getLine(int index) {
        if (index < 0 || index >= matrix.length) {
            throw new IllegalArgumentException();
        }

        return matrix[index];
    }

    public void setLine(int index, Vector vector) {
        if (index < 0 || index >= matrix.length) {
            throw new IllegalArgumentException();
        }

        matrix[index] = vector;
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= matrix[1].getSize()) {
            throw new IllegalArgumentException();
        }

        Vector result = new Vector(matrix.length);

        for (int i = 0; i < result.getSize(); i++) {
            result.setElement(i, matrix[i].getElement(index));
        }

        return result;
    }

    public void transpose() {
        Vector[] transposeMatrix = new Vector[matrix[0].getSize()];

        for (int i = 0; i < matrix[0].getSize(); i++) {
            transposeMatrix[i] = getColumn(i);
        }

        matrix = transposeMatrix;
    }

    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i].multiplicationByNumber(scalar);
        }
    }

    public void addition(Matrix addedMatrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i].addition(addedMatrix.getLine(i));
        }
    }

    public void subtraction(Matrix deductibleMatrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i].subtraction(deductibleMatrix.getLine(i));
        }
    }

    public void vectorMultiplication(Vector vector) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i].setElement(0, Vector.multiplication(getLine(i), vector));
        }
    }

    public static Matrix addition(Matrix matrix1, Matrix matrix2) {
        Matrix copyOfFirstMatrix = new Matrix(matrix1);

        copyOfFirstMatrix.addition(matrix2);

        return copyOfFirstMatrix;
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        Matrix copyOfFirstMatrix = new Matrix(matrix1);

        copyOfFirstMatrix.subtraction(matrix2);

        return copyOfFirstMatrix;
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        Matrix resultMatrix = new Matrix(matrix1.matrix.length, matrix2.matrix[0].getSize());
        double[][] result = new double[matrix1.matrix.length][matrix2.matrix[0].getSize()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {

            }
        }

        return new Matrix(result);
    }
}
