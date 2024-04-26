package onTapCode.MVC_pattern.test;

import onTapCode.MVC_pattern.model.CounterModel;
import onTapCode.MVC_pattern.view.CouterView;

public class Test {
    public static void main(String[] args) {
        CounterModel ct = new CounterModel();
        ct.increment();
        ct.decrement();
        ct.reset();
        System.out.println(ct.getValue());

        CouterView ctv = new CouterView();

    }
}
