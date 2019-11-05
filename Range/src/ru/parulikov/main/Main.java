package ru.parulikov.main;

import ru.parulikov.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range testRange = new Range(-4, 3);

        Range[] ranges = new Range[7];
        ranges[0] = new Range(testRange);
        ranges[1] = new Range(-2, 1);
        ranges[2] = new Range(-5, 4);
        ranges[3] = new Range(5, 7);
        ranges[4] = new Range(-10, -3);
        ranges[5] = new Range(-10, -5);
        ranges[6] = null;

        System.out.println("Длина интервалов");
        for (Range range : ranges) {
            if (range != null) {
                System.out.printf("Длина интервала %s равна %.2f%n", range, range.getLength());
            }
        }
        System.out.println("------------------");

        System.out.println("Принадлежит ли число интервалу");
        for (Range range : ranges) {
            if (range != null) {
                System.out.printf("Число 1%s принадлежит интервалу %s%n",
                        range.isInside(1) ? "" : " не", range);
            }
        }
        System.out.println("------------------");

        System.out.println("Пересечение интервалов");
        for (Range range : ranges) {
            try {
                System.out.printf("Пересечение %s и %s равно %s%n",
                        testRange, range, testRange.getIntersection(range));
            } catch (IllegalArgumentException e) {
                System.out.printf("%s и %s %s%n", testRange, range, e.getMessage());
            }
        }
        System.out.println("-----------------");

        System.out.println("Объединение интервалов");
        for (Range range : ranges) {
            System.out.printf("Объединение %s и %s равно %s%n",
                    testRange, range, Arrays.toString(testRange.getUnion(range)));
        }
        System.out.println("-----------------");

        System.out.println("Разность интервалов");
        for (Range range : ranges) {
            System.out.printf("Разность %s и %s равна %s%n",
                    testRange, range, Arrays.toString(testRange.getResidual(range)));
        }
        System.out.println("-----------------");

        System.out.println("Equals");
        for (Range range : ranges) {
            System.out.printf("Интервал %s%s равен интервалу %s%n",
                    testRange, testRange.equals(range) ? "" : " не", range);
        }
        System.out.println("-----------------");

        System.out.println("HashCode");
        for (Range range : ranges) {
            if (range != null) {
                System.out.printf("Хэш-код интервала %s равен %s%n", range, Integer.toHexString(range.hashCode()));
            }
        }
        System.out.println("-----------------");

        System.out.println("Геттеры и сеттеры");
        System.out.printf("Интервалу %s присваиваем %d и %d%n", testRange, -6, 9);
        testRange.setFrom(-6);
        testRange.setTo(9);

        System.out.printf("Переменные интервала %s: from = %.1f, to = %.1f%n",
                testRange, testRange.getFrom(), testRange.getTo());
        System.out.println("-----------------");
    }
}
