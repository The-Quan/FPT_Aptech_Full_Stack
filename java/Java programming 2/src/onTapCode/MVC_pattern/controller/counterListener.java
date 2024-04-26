package onTapCode.MVC_pattern.controller;

import onTapCode.MVC_pattern.view.CouterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class counterListener implements ActionListener {
    private CouterView ctv;
    public counterListener(CouterView ctv){
        this.ctv =ctv;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("ban da nhan nut! ");
        String src = e.getActionCommand();

        System.out.println("ban da nhan nut! " + src);

        if (src.equals("UP")){
         this.ctv.increment();
        }else if (src.equals("DOWN")){
            this.ctv.decrement();
        }else if (src.equals("RESET")){
            this.ctv.reset();
        }
    }
}
