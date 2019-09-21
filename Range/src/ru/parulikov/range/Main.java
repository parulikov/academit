package ru.parulikov.range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range[] ranges = new Range[8];

        ranges[0] = new Range(-4, 3);
        ranges[1] = new Range(-4, 3);
        ranges[2] = new Range(-2, 1);
        ranges[3] = new Range(-5, 4);
        ranges[4] = new Range(5, 7);
        ranges[5] = new Range(-10, -3);
        ranges[6] = new Range(-10, -5);
        ranges[7] = null;

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
        for (int i = 1; i < ranges.length; i++) {
            System.out.printf("Пересечение %s и %s равно %s%n",
                    ranges[0], ranges[i], Range.getRangesIntersection(ranges[0], ranges[i]));
        }
        System.out.println("-----------------");

        System.out.println("Объединение интервалов");
        for (int i = 1; i < ranges.length; i++) {
            System.out.printf("Объединение %s и %s равно %s%n",
                    ranges[0], ranges[i], Arrays.toString(Range.getRangesAssociation(ranges[0], ranges[i])));
        }
        System.out.println("-----------------");

        System.out.println("Разность интервалов");
        for (int i = 1; i < ranges.length; i++) {
            System.out.printf("Разность %s и %s равна %s%n",
                    ranges[0], ranges[i], Arrays.toString(Range.getRangesResidual(ranges[0], ranges[i])));
        }
        System.out.println("-----------------");

        System.out.println("Equals");
        for (int i = 1; i < ranges.length; i++) {
            System.out.printf("Интервал %s%s равен интервалу %s%n", ranges[0], ranges[0].equals(ranges[i]) ? "" : " не", ranges[i]);
        }
        System.out.println("-----------------");

        System.out.println("HashCode");
        for (Range range : ranges) {
            if (range != null) {
                System.out.printf("Хэш-код интервала %s равен %s%n", range, Integer.toHexString(range.hashCode()));
            }
        }
        System.out.println("-----------------");

        System.out.println("Пересечения");
        for (int i = 1; i < ranges.length; i++) {
            System.out.printf("%s%s пересекается с %s%n",
                    ranges[0], Range.isRangesIntersection(ranges[0], ranges[i]) ? "" : " не", ranges[i]);
        }
        System.out.println("-----------------");
    }
}
