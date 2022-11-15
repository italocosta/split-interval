package eurocontrol.splitinterval.model;

import java.util.Objects;

public class Interval {

    private Integer start;
    private Integer end;

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Interval() {
    }

    public Interval(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" +
                start +
                ", " + end +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start.equals(interval.start) && end.equals(interval.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
