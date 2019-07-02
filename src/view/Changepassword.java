package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;
import domain.Staff;

public class Changepassword extends JFrame{
	private JLabel l1;
	private JTextField f1;
	private JButton confirm;
	
	public Changepassword(){
		Container c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		JPanel jPanel1=new JPanel();
		l1=new JLabel("请输入修改后的密码：");
		f1=new JTextField(10);
		confirm=new JButton("保存");
		Font font=new Font("幼圆", Font.PLAIN, 20);
		l1.setFont(font);
		confirm.setFont(font);
		Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(20, 10, 600, 200);
		jPanel1.setLayout(null);
		l1.setForeground(Color.BLACK);
		l1.setBounds(10,30,200,40);
		f1.setBorder(border);
		f1.setBounds(200,35,150,30);
		confirm.setBackground(Color.WHITE);
		confirm.setBounds(130, 80, 100, 35);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("保存")){
					String update=f1.getText();
					String sql="update staff set staffpw='"+update+"'";
					try {
						DataConnect.getStat().executeUpdate(sql);
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					JOptionPane.showMessageDialog(null, "保存成功！"," ",JOptionPane.PLAIN_MESSAGE);
					dispose();
					new StaffFrame();
			}
});
		jPanel1.add(l1);
		jPanel1.add(f1);
		jPanel1.add(confirm);
		c.add(jPanel1);
		
		this.setTitle("修改密码");
		this.setSize(400,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Changepassword();
	}
}
