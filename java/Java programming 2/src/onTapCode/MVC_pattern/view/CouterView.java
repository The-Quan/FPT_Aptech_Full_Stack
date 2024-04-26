package onTapCode.MVC_pattern.view;

import onTapCode.MVC_pattern.controller.counterListener;
import onTapCode.MVC_pattern.model.CounterModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CouterView extends JFrame {
    private CounterModel counterModel;
    private JButton jButton_up;
    private JButton jButton_down;
    private JLabel jLabel_value;
    private JButton jButton_reset;

    public CouterView(){
        this.counterModel = new CounterModel();
        this.init();
        this.setVisible(true);
    }
    public void init(){
        this.setTitle("Counter");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener ac = new counterListener(this);

        jButton_up = new JButton("UP");
        jButton_up.addActionListener(ac);
        jButton_down = new JButton("DOWN");
        jButton_down.addActionListener(ac);
        jLabel_value = new JLabel(this.counterModel.getValue()+"",JLabel.CENTER);
        jButton_reset = new JButton("RESET");
        jButton_reset.addActionListener(ac);

        JPanel jPanel = new JPanel();

        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton_up, BorderLayout.WEST);
        jPanel.add(jLabel_value, BorderLayout.CENTER);
        jPanel.add(jButton_down,BorderLayout.EAST);
        jPanel.add(jButton_reset,BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(jPanel, BorderLayout.CENTER);
    }
    public void increment(){
        this.counterModel.increment();
        this.jLabel_value.setText(this.counterModel.getValue()+"");

    }
    public void decrement(){
        this.counterModel.decrement();
        this.jLabel_value.setText(this.counterModel.getValue()+"");

    }
    public void reset(){
        this.counterModel.reset();
        this.jLabel_value.setText(this.counterModel.getValue() +"");
    }
}
