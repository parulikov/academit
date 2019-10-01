package ru.parulikov.range;

public class Range {
    private double from;
    private double to;

    public Range(double a, double b) {
        from = Math.min(a, b);
        to = Math.max(a, b);
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

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getRangesIntersection(Range range) {
        if (range == null) {
            return null;
        }

        if ((from <= range.from && to >= range.from) ||
                (from <= range.to && to >= range.to) ||
                (from >= range.from && to <= range.to)) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    public Range[] getRangesAssociation(Range range) {
        if (range == null) {
            return new Range[]{new Range(this)};
        }

        if ((from <= range.from && to >= range.from) ||
                (from <= range.to && to >= range.to) ||
                (from >= range.from && to <= range.to)) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        return new Range[]{new Range(this), new Range(range)};
    }

    public Range[] getRangesResidual(Range range) {
        if (range == null || (from > range.to || to < range.from)) {
            return new Range[]{new Range(this)};
        }

        if (from >= range.from && to <= range.to) {
            return null;
        }

        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(to, range.to)};
        }

        if (from < range.from && to > range.from) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(to, range.to)};
    }

    @Override
    public int hashCode() {
        int hashCode = 53;

        hashCode = 41 * hashCode + Double.hashCode(from);
        hashCode = 41 * hashCode + Double.hashCode(to);

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

        Range range = (Range) obj;

        return from == range.getFrom() && to == range.getTo();
    }

    @Override
    public String toString() {
        return from + "..." + to;
    }
}
