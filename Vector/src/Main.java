import ru.parulikov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создание нулевого вектора");
        Vector vector1 = new Vector(6);
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Создание вектора из массива");
        vector1 = new Vector(new double[]{4, 5, 6});
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Создание вектора определенной длинны из массива");
        vector1 = new Vector(3, new double[]{3, 5, 8, 1, 4, 9});
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Создание вектора из другого вектора");
        Vector vector2 = new Vector(vector1);
        System.out.println(vector2);
        System.out.println("-----------------");

        vector1 = new Vector(new double[]{5, 2, 7, 2});

        System.out.println("Сложение векторов");
        System.out.println(Vector.addition(vector1, vector2));
        System.out.println("-----------------");

        System.out.println("Вычитание векторов");
        System.out.println(Vector.subtraction(vector1, vector2));
        System.out.println("-----------------");

        System.out.println("Умножение векторов");
        System.out.println(Vector.multiplication(vector1, vector2));
        System.out.println("-----------------");

        System.out.println("Размер вектора");
        System.out.println(vector1.getSize());
        System.out.println("-----------------");

        System.out.println("Элемент вектора");
        System.out.println(vector1.getElement(0));
        System.out.println("-----------------");

        System.out.println("Задание элемнта вектора по индексу");
        vector1.setElement(0, 6);
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Прибавление вектора к другому");
        vector1.addition(vector2);
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Вычитание вектора из другого");
        vector1.subtraction(new Vector(new double[]{6, 1, 4, 76, 2, 2}));
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Скалярное умножение");
        vector1.multiplication(6);
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Разворот вектора");
        vector1.turn();
        System.out.println(vector1);
        System.out.println("-----------------");

        System.out.println("Хэш-код");
        System.out.println(vector1.hashCode());
        System.out.println("-----------------");

        System.out.println("Equals");
        vector2 = new Vector(vector1);
        System.out.println(vector1.equals(vector2));
    }
}
