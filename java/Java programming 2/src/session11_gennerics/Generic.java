package session11_gennerics;

import session11_gennerics.model.KeyValue;

public class Generic {
    public static void main(String[] args) {
       KeyValue<Integer,String> entry = new KeyValue<Integer,String>(12435,"Quan");
       Integer phone = entry.getKey();
       String name = entry.getValue();
        System.out.println(phone + " " + name);
    }
}
