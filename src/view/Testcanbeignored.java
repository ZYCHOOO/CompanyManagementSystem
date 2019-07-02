package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Testcanbeignored extends JFrame{
	private String[] weekDays = {
			"Mon",
			"Tue",
			"Wed",
			"Thu",
			"Fri",
			"Sat",
			"Sun"
	};
	private JTextField t = new JTextField(15);
	private JComboBox c = new JComboBox();
	private JButton b = new JButton("Add items");
	private int count = 0;
	public Testcanbeignored() {
		// TODO Auto-generated constructor stub
		
		setLayout(new FlowLayout());
		setSize(200,175);
		setVisible(true);
		
		for(int i = 0; i < 3;i++)
			c.addItem(weekDays[count++]);
		t.setEditable(false);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(count < weekDays.length){
					c.addItem(weekDays[count++]);
					
				}
			}
		});
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.setText("ÄúÑ¡ÔñÁË "+ c.getSelectedItem());
			}
		});
		c.setEditable(true);
		
		add(t);
		add(c);
		add(b);
	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Testcanbeignored();
	}

}

