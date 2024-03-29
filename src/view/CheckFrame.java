package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import dao.DataConnect;
import dao.ImageDemo;
import dao.ModelFactory;

public class CheckFrame extends JFrame{
	private JLabel l1;
	private JButton confirm;
	private static JTextField f1;
	
	public CheckFrame(){
		Container c=this.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
		JPanel jPanel=new JPanel();
        l1=new JLabel("请输入员工编号");
        f1=new JTextField(10);
        confirm=new JButton("确认");
        Font font=new Font("幼圆", Font.PLAIN, 15);
        Font fontBtn=new Font("黑体", Font.PLAIN, 20);
        Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);
        jPanel.setBounds(50,20,500,400);
        l1.setFont(font);
        l1.setForeground(Color.BLACK);
        l1.setBounds(40,-20,200,80);
        f1.setBorder(border);
        f1.setBounds(5,50,200,30);
        confirm.setFont(fontBtn);
        confirm.setBounds(55,100,80,30);
        confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getActionCommand().equals("确认")){
//					dispose();
//					
//				}
				try {
					ResultSet rs = ModelFactory.searchid(Integer.parseInt(f1.getText()));
					if(rs.next()){
						ImageDemo.readDB2Image();
						new RoughFOM();
						
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "查找不到该员工 ", "出错了 ", JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
        jPanel.add(l1);
        jPanel.add(f1);
        jPanel.add(confirm);
        c.add(jPanel);
		
		this.setTitle("查找员工");//后期需要更改Title
		this.setSize(300,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static String getf1(){
		return f1.getText();
	}
	
	public static void main(String[] args) {
		new CheckFrame();
	}
}
