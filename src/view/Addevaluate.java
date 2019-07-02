package view;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Addevaluate extends JFrame{
	private JButton confirm;
	String idtxt = CheckFrame.getf1();
	public Addevaluate(){
		Container c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
        JTextArea jTextArea=new JTextArea();
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEnabled(true);
        jTextArea.setFont(new Font("��Բ", Font.PLAIN, 20));
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setBackground(Color.WHITE);
        jScrollPane.setBorder(border);
        jScrollPane.setBounds(30,20,230,120);
        c.add(jScrollPane);
        
        String sql = "select * from staffcond where workid="+idtxt+"";
        String check = null;
        try {
			ResultSet rs = DataConnect.getStat().executeQuery(sql);
			if(rs.next()){
				check = rs.getString(3);
			}
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        jTextArea.setText(check);
        
        confirm=new JButton("����");
        Font Btnfont=new Font("��Բ", Font.PLAIN, 20);
        confirm.setFont(Btnfont);
        confirm.setBounds(100, 150, 100, 35);
        confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String evalu = jTextArea.getText();
				System.out.println(evalu);
				String sql = "update staffcond set evaluate='"+evalu+"' where workid="+idtxt+"";
				try {
					DataConnect.getStat().executeUpdate(sql);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "����ɹ�", " ", JOptionPane.PLAIN_MESSAGE);
				dispose();
				new AdminFrame();
			}
		});
        c.add(confirm);
        
		this.setTitle("��������");
		this.setSize(300, 250);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Addevaluate();
	}
}
