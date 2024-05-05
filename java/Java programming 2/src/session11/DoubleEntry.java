package session11;

import session11.model.KeyValue;

public class DoubleEntry<V> extends KeyValue<Double, V> {
    public DoubleEntry(double key, V value) {
        super(key, value);
    }

    public static void main(String[] args) {
        DoubleEntry<Double> entry = new DoubleEntry<>(9.88,33.3);
        double key = entry.getKey();
        double value = entry.getValue();
        System.out.println(key + " " + value);
    }
}
