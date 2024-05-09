package session11_gennerics;

import session11_gennerics.model.KeyValue;

public class NumberEntry extends KeyValue<Integer, String> {
    public NumberEntry(Integer key, String value) {
        super(key, value);
    }
}
