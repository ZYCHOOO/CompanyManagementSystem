package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;

public class AdminFrame extends JFrame{
	private JLabel l1,l2,l3,l4;
	private JButton insert,delete,check,alter,exit;
	
	
	public AdminFrame(){
		Container c = this.getContentPane();  
        c.setBackground(Color.WHITE);  
        c.setLayout(null); 
        
        JPanel jPanel1=new JPanel();
        l1=new JLabel("员 工 管 理 系 统",JLabel.CENTER);
        Font font=new Font("华文彩云", Font.PLAIN, 30);//字体样式随便设置
        l1.setFont(font);
        l1.setForeground(Color.BLUE);
        jPanel1.setLayout(new BorderLayout());
//        jPanel1.setBackground(Color.blue);
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBounds(50, 5, 360, 70);
        jPanel1.add(l1,BorderLayout.SOUTH);
        c.add(jPanel1);
        
        Date now=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
        String strDate=sdf.format(now);
        String strTime=sdf2.format(now);
        JTextArea jTextArea=new JTextArea("欢迎登陆！今天是："+strDate);//jTextArea的颜色不能设置，后期能改的话要修改
        jTextArea.append("\n");
        jTextArea.append("现在时间是："+strTime);
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEnabled(false);//在 文本框内不能键入字符内容
        jTextArea.setFont(new Font("幼圆", Font.PLAIN, 20));
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setBackground(Color.WHITE);
        jScrollPane.setBorder(border);
        jScrollPane.setBounds(30,85,400,200);
        c.add(jScrollPane);
        
        JPanel jPanel3=new JPanel();
        jPanel3.setBackground(Color.WHITE);
        jPanel3.setBounds(30, 300, 400, 165);
        Font fontButton=new Font("幼圆", Font.PLAIN, 22);
        jPanel3.setLayout(new GridLayout(5,1,0,5));
        
        insert=new JButton("添加员工消息");
        insert.setFont(fontButton);
        insert.setBackground(Color.WHITE);
        insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("添加员工消息")){
					dispose();
					new InsertFrame();
				}
			}
		});
        jPanel3.add(insert);
        
        delete=new JButton("删除员工信息");
        delete.setFont(fontButton);
        delete.setBackground(Color.WHITE);
        delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("删除员工信息")){
					dispose();
					new DeleteFrame();
				}
			}
		});
        jPanel3.add(delete);
        
        check=new JButton("查看员工信息");
        check.setFont(fontButton);
        check.setBackground(Color.WHITE);
        check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("查看员工信息")){
					dispose();
					new CheckFrame();
				}
			}
		});
        jPanel3.add(check);
        
        alter=new JButton("修改员工信息");
        alter.setFont(fontButton);
        alter.setBackground(Color.WHITE);
        alter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("修改员工信息")){
					dispose();
					new AlterFrame();
				}
				
			}
		});
        jPanel3.add(alter);
        
        exit=new JButton("退出管理系统");
        exit.setFont(fontButton);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Login();
				
			}
		});
        jPanel3.add(exit);
        c.add(jPanel3);
        
        this.setTitle("主界面");//setTiltle到时需要改名字 
        this.setSize(460,520);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void GiveID(){
		int[] id=new int[8];
		for(int i=0;i<id.length;i++){
			id[i]=(int)(Math.random()*100);
			System.out.println(id);
		}
		return;
	}
	
	public static void main(String[] args) {
		new AdminFrame();
//		int[] id=new int[8];
//		for(int i=0;i<id.length;i++){
//			id[i]=(int)(Math.random()*100);
//		}
	}

}
