package ru.parulikov.range;

public class Range {
    private double from;
    private double to;
    private Integer hashCode;

    public Range(double a, double b) {
        from = a <= b ? a : b;
        to = a > b ? a : b;
    }

    public Range(Range range) {
        from = range.getFrom();
        to = range.getTo();
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public boolean isInside(Range range) {
        if (range == null) {
            return false;
        }

        return from >= range.getFrom() && to <= range.getTo();
    }

    public static boolean isRangesIntersection(Range a, Range b) {
        if (a == null || b == null) {
            return false;
        }

        return (a.isInside(b)) ||
                (b.isInside(a)) ||
                (a.getFrom() <= b.getFrom() && a.getTo() >= b.getFrom()) ||
                (b.getFrom() <= a.getFrom() && b.getTo() >= a.getFrom());
    }

    public static Range getRangesIntersection(Range a, Range b) {
        if (a == null || b == null) {
            return null;
        }

        if (isRangesIntersection(a, b)) {
            if (a.isInside(b)) {
                return new Range(a);
            } else if (b.isInside(a)) {
                return new Range(b);
            } else if (a.getFrom() >= b.getFrom() && a.getTo() <= b.getFrom() && b.getTo() > a.getTo()) {
                return new Range(b.getFrom(), a.getTo());
            } else {
                return new Range(a.getFrom(), b.getTo());
            }
        }

        return null;
    }

    public static Range[] getRangesAssociation(Range a, Range b) {
        if (a == null && b == null) {
            return new Range[]{};
        } else if (a == null) {
            return new Range[]{new Range(b)};
        } else if (b == null) {
            return new Range[]{new Range(a)};
        }

        if (!isRangesIntersection(a, b)) {
            return new Range[]{new Range(a), new Range(b)};
        }

        if (a.isInside(b)) {
            return new Range[]{new Range(b)};
        } else if (b.isInside(a)) {
            return new Range[]{new Range(a)};
        } else if (a.getFrom() >= b.getFrom() && a.getTo() <= b.getFrom() && b.getTo() > a.getTo()) {
            return new Range[]{new Range(a.getFrom(), b.getTo())};
        } else {
            return new Range[]{new Range(b.getFrom(), a.getTo())};
        }
    }

    public static Range[] getRangesResidual(Range a, Range b) {
        if (a == null && b == null) {
            return new Range[]{};
        } else if (a == null) {
            return new Range[]{new Range(b)};
        } else if (b == null) {
            return new Range[]{new Range(a)};
        }

        if (!isRangesIntersection(a, b)) {
            return new Range[]{new Range(a)};
        }

        if (a.equals(b)) {
            return new Range[]{};
        } else if (b.isInside(a)) {
            return new Range[]{new Range(a.getFrom(), b.getFrom()), new Range(a.getTo(), b.getTo())};
        } else if (a.isInside(b)) {
            return new Range[]{};
        } else if (a.getFrom() >= b.getFrom() && a.getTo() <= b.getFrom() && b.getTo() > a.getTo()) {
            return new Range[]{new Range(a.getFrom(), b.getFrom())};
        } else {
            return new Range[]{new Range(b.getTo(), a.getTo())};
        }
    }

    @Override
    public int hashCode() {
        if (hashCode != null) {
            return hashCode;
        }

        int result = 53;

        result = 41 * result + (int) (Double.doubleToLongBits(from) - (Double.doubleToLongBits(from) >>> 32));
        result = 41 * result + (int) (Double.doubleToLongBits(to) - (Double.doubleToLongBits(to) >>> 32));

        hashCode = result;
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

        if (hashCode() != obj.hashCode()) {
            return false;
        }

        return from == ((Range) obj).getFrom() && to == ((Range) obj).getTo();
    }

    @Override
    public String toString() {
        return from + "..." + to;
    }
}
