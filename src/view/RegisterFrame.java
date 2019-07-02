package view;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;
import dao.ModelFactory;
import domain.Admin;
import domain.Staff;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class RegisterFrame extends JFrame{
	private JTextField f1;
	private JButton confirm,exit;
	private JLabel l1,l2,l3;
	private JPasswordField p1;
	private JRadioButton staff,admin;
	
	public RegisterFrame(){
		Container c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		JPanel jPanel1=new JPanel();
		JLabel l1 = new JLabel("注 册 界 面", JLabel.CENTER);  
        Font font = new Font("华文彩云", Font.PLAIN, 30);    
        l1.setFont(font);  
        l1.setForeground(Color.BLUE);  
        jPanel1.setLayout(new BorderLayout());  
        // jPanel1.setBackground(Color.blue);  
        jPanel1.setBackground(Color.WHITE);  
        jPanel1.setBounds(10, 5, 300, 50);   
        jPanel1.add(l1, BorderLayout.SOUTH);  
        c.add(jPanel1);
        
        JPanel jPanel2=new JPanel();
        Font fontText = new Font("幼圆", Font.PLAIN, 20);  
        Border border = new MatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY);  
        jPanel2.setLayout(null);  
        jPanel2.setBackground(Color.WHITE);  
        jPanel2.setBounds(5, 80, 300, 50);  
        JLabel l2 = new JLabel("账  号：");  
        l2.setFont(fontText);  
        l2.setBounds(10,5,80,40);  
        f1= new JTextField();  
        f1.setBorder(border);  
        f1.setBounds(90,10,200,30);  
        f1.setFont(fontText);  
        jPanel2.add(l2);  
        jPanel2.add(f1);  
        c.add(jPanel2);
        
        JPanel jPanel3 = new JPanel();  
        Font fontPassword = new Font("幼圆", Font.PLAIN, 20);  
        jPanel3.setLayout(null);  
        jPanel3.setBackground(Color.WHITE);  
        jPanel3.setBounds(5, 140, 300, 50);  
        JLabel l3 = new JLabel("密  码：");  
        l3.setFont(fontPassword);  
        l3.setBounds(10,5,80,40);  
        p1= new JPasswordField();  
        p1.setEchoChar('*');  
        p1.setBorder(border);  
        p1.setBounds(90,10,200,30);  
        p1.setFont(fontPassword);  
        jPanel3.add(l3);  
        jPanel3.add(p1);  
        c.add(jPanel3);
        
//        staff=new JRadioButton("员工");
//        staff.setBounds(70, 200, 100, 35);
//        Font RdBtnFont=new Font("幼圆", Font.PLAIN, 20);
//        staff.setFont(RdBtnFont);
//        staff.setBackground(Color.WHITE);
//        c.add(staff);
//        
//        admin=new JRadioButton("管理员");
//        admin.setBounds(180,200,100,35);
//        admin.setFont(RdBtnFont);
//        admin.setBackground(Color.WHITE);
//        c.add(admin);
        
//        ButtonGroup bg=new ButtonGroup();
//        bg.add(staff);
//        bg.add(admin);
        
        confirm= new JButton("保存");  
        confirm.setBounds(50, 240, 100, 35);
        Font BtnFont = new Font("幼圆", Font.PLAIN, 20);
        confirm.setFont(BtnFont);  
        confirm.setBackground(Color.WHITE);
        confirm.addActionListener(new ActionListener() {
			
//			@Override
			Admin ad;
//			Staff sf;
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("保存")){
//					if(admin.isSelected()){
					try {
						ad=ModelFactory.regisad(Integer.parseInt(f1.getText()), p1.getText());
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
//					}else if(staff.isSelected()){
//						String update=p1.getText();
//						String sql="update staff set staffpw='"+update+"'";
//						try {
////							sf=ModelFactory.regissf(Integer.parseInt(f1.getText()), p1.getText());
//							DataConnect.getStat().executeUpdate(sql);
//						} catch (NumberFormatException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (ClassNotFoundException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
					JOptionPane.showMessageDialog(null, "保存成功！"," ",JOptionPane.PLAIN_MESSAGE);
					dispose();
					new Login();
					}
				}
		});
        c.add(confirm);
        
        exit=new JButton("关闭");
        exit.setBounds(180,240,100,35);
        exit.setFont(BtnFont);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("关闭")){
					int n=JOptionPane.showConfirmDialog(null, "是否退出注册？"," ",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						dispose();
						new Login();
					}else{
						dispose();
						new RegisterFrame();
					}
				}
			}
		});
        c.add(exit);
		
		this.setTitle("注册界面");
		this.setVisible(true);
		this.setSize(320, 340);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new RegisterFrame();
	}

}
