package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import dao.DataConnect;
import dao.ImageDemo;

import java.awt.event.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToAlter extends JFrame{
	private JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField f1,f2,f3,f4,f5,f6,f7,f8,f9;
	private JButton confirm,cancel,alterphoto;
	private String[] sex={"男","女"};
	private String[] qualification={"大专","本科","研究生"};
	private int count=0;
	private int count2=0;
	String idtxt = AlterFrame.getf1();
	private static String path;
	public ToAlter(){
		Container c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		JPanel jPanel=new JPanel();
        l0=new JLabel("修 改 员 工 信 息");
        Font font0=new Font("华文彩云", Font.PLAIN, 30);
        l0.setFont(font0);
        l0.setForeground(Color.BLUE);
        jPanel.setLayout(new BorderLayout());
        jPanel.setBackground(Color.WHITE);
        jPanel.setBounds(180,-30,360,70);
        jPanel.add(l0,BorderLayout.SOUTH);
        c.add(jPanel);
        
        JPanel jPanel1=new JPanel();
		l1=new JLabel("员工编号");
		f1=new JTextField(10);
		Font font=new Font("幼圆", Font.PLAIN, 20);
		Font fontBtn1=new Font("幼圆", Font.PLAIN, 15);
		Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel1.setLayout(null);
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(5,50,300,50);
		l1.setFont(font);
		l1.setForeground(Color.BLACK);
		l1.setBounds(10,5,80,40);
		f1.setBorder(border);
		f1.setBounds(90,10,100,30);
		f1.setEditable(false);
		jPanel1.add(l1);
		jPanel1.add(f1);
		c.add(jPanel1);
		
		JPanel jPanel2=new JPanel();
		l2=new JLabel("姓   名");
		f2=new JTextField(15);
		Font font2=new Font("幼圆", Font.PLAIN, 20);
		Border border2=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel2.setLayout(null);
		jPanel2.setBackground(Color.WHITE);
		jPanel2.setBounds(5,100,300,50);
		l2.setFont(font2);
		l2.setForeground(Color.BLACK);
		l2.setBounds(15,15,80,40);
		f2.setBorder(border2);
		f2.setBounds(90,20,100,30);
//		f2.setEditable(false);
		jPanel2.add(l2);
		jPanel2.add(f2);
		c.add(jPanel2);
		
		JPanel jPanel3=new JPanel();
		l3=new JLabel("性   别");
		f3=new JTextField(5);
		JComboBox box=new JComboBox();
		for(int i=0;i<2;i++)
			box.addItem(sex[count++]);
		f3.setEditable(false);
		Font font3=new Font("幼圆", Font.PLAIN, 20);
		Border border3=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel3.setLayout(null);
		jPanel3.setBackground(Color.WHITE);
		jPanel3.setBounds(5,150,500,50);
		l3.setFont(font3);
//		l3.setEnabled(false);
		l3.setForeground(Color.BLACK);
		l3.setBounds(15,15,80,40);
		f3.setBorder(border3);
		f3.setBounds(90,20,50,30);
		box.setBounds(150,20,70,30);
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f3.setText((String) box.getSelectedItem());
			}
		});
		box.setEditable(true);
		jPanel3.add(l3);
		jPanel3.add(f3);
		jPanel3.add(box);
		c.add(jPanel3);
		
		JPanel jPanel4=new JPanel();
		l4=new JLabel("身份证号");
		f4=new JTextField(18);
		Font font4=new Font("幼圆", Font.PLAIN, 20);
		Border border4=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel4.setLayout(null);
		jPanel4.setBackground(Color.WHITE);
		jPanel4.setBounds(5,200,300,50);
		l4.setFont(font4);
		l4.setForeground(Color.BLACK);
		l4.setBounds(10,15,80,40);
		f4.setBorder(border4);
		f4.setBounds(90,20,150,30);
//		f4.setEditable(false);
		jPanel4.add(l4);
		jPanel4.add(f4);
		c.add(jPanel4);
		
		JPanel jPanel5=new JPanel();
		l5=new JLabel("出生日期");
		f5=new JTextField(20);//规定输入格式位yyyy-MM-dd，否则判断为非法字符（Simpledateformat）
		Font font5=new Font("幼圆", Font.PLAIN, 20);
		Border border5=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel5.setLayout(null);
		jPanel5.setBackground(Color.WHITE);
		jPanel5.setBounds(5,250,300,50);
		l5.setFont(font5);
		l5.setForeground(Color.BLACK);
		l5.setBounds(10,15,80,40);
		f5.setBorder(border5);
		f5.setBounds(90,20,150,30);
//		f5.setEditable(false);
		jPanel5.add(l5);
		jPanel5.add(f5);
		c.add(jPanel5);
		
		JPanel jPanel6=new JPanel();
		l6=new JLabel("学   历");
		f6=new JTextField(5);
		JComboBox box2=new JComboBox();
		for(int j=0;j<3;j++)
			box2.addItem(qualification[count2++]);
		f6.setEditable(false);
		Font font6=new Font("幼圆", Font.PLAIN, 20);
		Border border6=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel6.setLayout(null);
		jPanel6.setBackground(Color.WHITE);
		jPanel6.setBounds(5, 300,500, 50);
		l6.setFont(font6);
//		l6.setEnabled(false);
		l6.setForeground(Color.BLACK);
		l6.setBounds(15,15,80,40);
		f6.setBorder(border3);
		f6.setBounds(90,20,50,30);
		box2.setBounds(150,20,70,30);
		box2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f6.setText((String) box2.getSelectedItem());
			}
		});
		box2.setEditable(true);
		jPanel6.add(l6);
		jPanel6.add(f6);
		jPanel6.add(box2);
		c.add(jPanel6);
		
		JPanel jPanel7=new JPanel();
		l7=new JLabel("职   位");
		f7=new JTextField(10);
		Font font7=new Font("幼圆", Font.PLAIN, 20);
		Border border7=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel7.setLayout(null);
		jPanel7.setBackground(Color.WHITE);
		jPanel7.setBounds(5,350,300,50);
		l7.setFont(font7);
		l7.setForeground(Color.BLACK);
		l7.setBounds(15,15,80,40);
		f7.setBorder(border7);
		f7.setBounds(90,20,100,30);
//		f7.setEditable(false);
		jPanel7.add(l7);
		jPanel7.add(f7);
		c.add(jPanel7);
		
		JPanel jPanel8=new JPanel();
		confirm=new JButton("保  存");
		cancel=new JButton("关  闭");
		Font fontBtn2=new Font("黑体", Font.PLAIN, 20);
		jPanel8.setLayout(null);
		jPanel8.setBackground(Color.WHITE);
		jPanel8.setBounds(5,450,500,50);
		confirm.setFont(fontBtn2);
		confirm.setBounds(100,15,100,30);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("保  存")){
					String[] alter = new String[7];
					alter[0] = f1.getText();
					alter[1] = f2.getText();
					alter[2] = f3.getText();
					alter[3] = f4.getText();
					alter[4] = f5.getText();
					alter[5] = f6.getText();
					alter[6] = f7.getText();
					String sql = "update staff set name='"+alter[1]+"',sex='"+alter[2]+"',idcard="
					+alter[3]+",birth='"+alter[4]+"',position='"+alter[6]+"',education='"+alter[5]
							+"' where workid="+alter[0]+"";
					try {
						DataConnect.getStat().executeUpdate(sql);
						ImageDemo.readImage2DB();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
			}
		});
		cancel.setFont(fontBtn2);
		cancel.setBounds(350,15,100,30);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("关  闭")){
					int n=JOptionPane.showConfirmDialog(null, "是否退出修改？"," ",JOptionPane.YES_NO_OPTION);
						if(n==JOptionPane.YES_OPTION){
							new AdminFrame();
							dispose();
							
						}else{
							dispose();
							new AlterFrame();
						}					
				}
			}
		});
		jPanel8.add(confirm);
		jPanel8.add(cancel);
		c.add(jPanel8);
		
		JPanel jPanel9=new JPanel();
//		l8=new JLabel("照片设置为员工ID.jpg");
		alterphoto=new JButton("添加照片");
		alterphoto.setIcon(new ImageIcon("src/image/"+idtxt+".jpg"));
		Font font8=new Font("幼圆", Font.PLAIN, 10);
		jPanel9.setLayout(null);
		jPanel9.setBackground(Color.WHITE);
		jPanel9.setBounds(300,-40,600,600);
		alterphoto.setFont(font8);
		alterphoto.setBounds(100,120,100,150);
		alterphoto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File f;
				JFileChooser jfc=new JFileChooser();
				jfc.showOpenDialog(null);
				f=jfc.getSelectedFile();
				alterphoto.setIcon(new ImageIcon(f.getAbsolutePath()));
				System.out.println(f.getAbsolutePath());
				setalpath(f.getAbsolutePath());
			}
		});
//		l8.setFont(font8);
//		l8.setForeground(Color.BLACK);
//		l8.setBounds(100,50,500,100);
		jPanel9.add(alterphoto);
//		jPanel9.add(l8);
		c.add(jPanel9);
		
		this.setTitle("修改界面");//后期更改！
		this.setSize(550,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object[] info = new Object[7];
		String sql = "select * from staff where workid="+idtxt+"";
		try {
			ResultSet rs=DataConnect.getStat().executeQuery(sql);
			if(rs.next()){
				info[0] = rs.getInt(1);
				info[1] = rs.getString(3);
				info[2] = rs.getString(4);
				info[3] = rs.getLong(5);
				info[4] = rs.getString(6);
				info[5] = rs.getString(7);
				info[6] = rs.getString(8);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		f1.setText(String.valueOf(info[0]));
		f2.setText((String) info[1]);
		f3.setText((String) info[2]);
		f4.setText(String.valueOf(info[3]));
		f5.setText((String) info[4]);
		f6.setText((String) info[6]);
		f7.setText((String) info[5]);
		
	}
	
	public void setalpath(String path){
		this.path=path;
	}
	
	public static String getalpath(){
		return path;
	}
	public static void main(String[] args) {
		new ToAlter();
	}

}
