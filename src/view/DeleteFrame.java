package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;

public class DeleteFrame extends JFrame{
	private JLabel l1;
	private JButton confirm,cancel;
	private JTextField f1;
//	String workid = f1.getText();
	public DeleteFrame(){
		Container c=this.getContentPane();
		c.setBackground(Color.WHITE);  
        c.setLayout(null);
        
        JPanel jPanel=new JPanel();
        l1=new JLabel("请输入员工编号");
        f1=new JTextField(10);
        confirm=new JButton("确认");
        cancel=new JButton("取消");
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
        confirm.setBounds(0,100,80,30);
        confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("确认")){
					String workid = f1.getText();
					String sql = "delete from staff where workid ="+Integer.parseInt(workid)+"";
					try {
						DataConnect.getStat().executeUpdate(sql);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "删除成功！");
					dispose();
					new AdminFrame();
				}
			}
		});
        cancel.setFont(fontBtn);
        cancel.setBounds(130,100,80,30);
        cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("取消")){
					dispose();
					new AdminFrame();
				}
			}
		});
        jPanel.add(l1);
        jPanel.add(f1);
        jPanel.add(confirm);
        jPanel.add(cancel);
        c.add(jPanel);
		
		this.setTitle("删除员工信息");//此处setTitle需要后期修改
		this.setSize(300,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		new DeleteFrame();
	}
	
}
