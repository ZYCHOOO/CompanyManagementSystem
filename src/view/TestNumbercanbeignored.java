package view;

import javax.swing.*;
import javax.swing.GroupLayout.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.border.*;

public class TestNumbercanbeignored extends JFrame{
	private JTextField jTextField1;
    public TestNumbercanbeignored() {
    initComponents();
    double random = new Random().nextDouble();
    jTextField1.setText(Double.toString(random));
    }
    private void initComponents() {
        jTextField1 = new JTextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextField1.setText("jTextField1");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        pack();
    }
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestNumbercanbeignored().setVisible(true);
            }
        });
    }
}