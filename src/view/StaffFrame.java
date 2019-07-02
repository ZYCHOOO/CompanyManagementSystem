package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;

public class StaffFrame extends JFrame{
	private JLabel l1;
	private JButton signin,exit,checkevalute,changepassword;
	String idtxt = Login.getname();
	public StaffFrame(){
		Container c=this.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
		JPanel jPanel1=new JPanel();
		l1=new JLabel("员  工  界  面");
		Font font=new Font("华文彩云", Font.PLAIN, 30);//字体样式随便设置
        l1.setFont(font);
        l1.setForeground(Color.BLUE);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBounds(140, 5, 360, 70);
        jPanel1.add(l1,BorderLayout.SOUTH);
        c.add(jPanel1);
		
        Date now=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String strDate=sdf.format(now);
        JTextArea jTextArea=new JTextArea("欢迎登陆！今天是："+strDate);//jTextArea的颜色不能设置，后期能改的话要修改
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEnabled(false);//在 文本框内不能键入字符内容
        jTextArea.setFont(new Font("幼圆", Font.PLAIN, 20));
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setBackground(Color.WHITE);
        jScrollPane.setBorder(border);
        jScrollPane.setBounds(30,85,360,100);
        c.add(jScrollPane);
        
        checkevalute=new JButton("查 看 评 价");
        checkevalute.setBounds(60, 200, 300, 35);
        Font BtnFont = new Font("幼圆", Font.PLAIN, 20);
        checkevalute.setFont(BtnFont);  
        checkevalute.setBackground(Color.WHITE);
        checkevalute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Checkevaluate();
			}
		});
        c.add(checkevalute);
        
        changepassword=new JButton("修 改 密 码");
        changepassword.setBounds(60, 250, 300, 35);
        changepassword.setFont(BtnFont);  
        changepassword.setBackground(Color.WHITE);
        changepassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Changepassword();
			}
		});
        c.add(changepassword);
        
//        String condition = "成功打卡";
        signin=new JButton("打卡");
        signin.setBounds(50, 300, 100, 35);
        signin.setFont(BtnFont);
        signin.setBackground(Color.WHITE);
        signin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
				String strTime=sdf2.format(now);
				jTextArea.append("\n");
				jTextArea.append("打卡成功！打卡时间："+strTime);
				String condition = "打卡成功！打卡时间："+strDate+" "+strTime;
				String sql = "update staffcond set signcond='"+condition+"' where workid="+idtxt+"";
				try {
					DataConnect.getStat().executeUpdate(sql);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "打卡完成！");
			}
		});
        c.add(signin);
        
        exit=new JButton("退出");
        exit.setBounds(270,300,100,35);
        exit.setFont(BtnFont);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Login();
			}
		});
        c.add(exit);
		
		this.setTitle("员工界面");//后期更改
		this.setSize(440,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new StaffFrame();
	}
}
