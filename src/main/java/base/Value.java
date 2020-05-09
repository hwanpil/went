package base;

import java.util.Objects;

public class Value {
    private double value;
    private String unit;

    public Value(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return Double.compare(value1.value, value) == 0 &&
                Objects.equals(unit, value1.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
