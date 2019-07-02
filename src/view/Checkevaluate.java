package view;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkevaluate extends JFrame{
	private JButton confirm;
	String idtxt = Login.getname();
	public Checkevaluate(){
		Container c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		JTextArea jTextArea=new JTextArea();
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEnabled(false);
        jTextArea.setFont(new Font("幼圆", Font.PLAIN, 20));
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setBackground(Color.WHITE);
        jScrollPane.setBorder(border);
        jScrollPane.setBounds(30,20,230,120);
        c.add(jScrollPane);
        
        String evalua = null;
        String sql = "select * from staffcond where workid="+idtxt+"";
        try {
			ResultSet rs=DataConnect.getStat().executeQuery(sql);
			if(rs.next()){
				evalua=rs.getString(3);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        jTextArea.setText(evalua);
        
        confirm=new JButton("确认");
        Font Btnfont=new Font("幼圆", Font.PLAIN, 20);
        confirm.setFont(Btnfont);
        confirm.setBounds(100, 150, 100, 35);
        confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new StaffFrame();
			}
		});
        c.add(confirm);
		
		this.setTitle("查看评价");
		this.setSize(300, 250);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new Checkevaluate();
	}
}
