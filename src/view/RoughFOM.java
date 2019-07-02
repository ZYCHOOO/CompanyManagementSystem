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

public class RoughFOM extends JFrame{
	private JLabel l1,l2,l3,l4,l5;
	private JButton detail,close;
	private JTextField f1,f2,f3;
	String idtxt = CheckFrame.getf1();
	public RoughFOM(){
		Image img = Toolkit.getDefaultToolkit().createImage("src/image/"+idtxt+".jpg");
		Container c=this.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		JPanel jPanel1=new JPanel();
		l1=new JLabel("员 工 信 息");
		Font font1=new Font("华文彩云", Font.PLAIN, 30);
		l1.setFont(font1);
		l1.setForeground(Color.BLUE);
		jPanel1.setLayout(new BorderLayout());
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(150,-30,360,70);
        jPanel1.add(l1,BorderLayout.SOUTH);
		c.add(jPanel1);
		
		JPanel jPanel2=new JPanel();
		l2=new JLabel("员工编号");
		f1=new JTextField(10);
		l3=new JLabel("姓   名");
		f2=new JTextField(15);
		l4=new JLabel("职   位");
		f3=new JTextField(10);
		Font font2=new Font("幼圆",Font.PLAIN,20);
		Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel2.setLayout(null);
		jPanel2.setBackground(Color.WHITE);
		jPanel2.setBounds(5,50,300,300);
		l2.setFont(font2);
		l2.setForeground(Color.BLACK);
		l2.setBounds(10,55,80,40);
		f1.setBorder(border);
		f1.setBounds(90,60,100,30);
		f1.setEditable(false);
		l3.setFont(font2);
		l3.setForeground(Color.BLACK);
		l3.setBounds(10,105,80,40);
		f2.setBorder(border);
		f2.setBounds(90,110,100,30);
		f2.setEditable(false);
		l4.setFont(font2);
		l4.setForeground(Color.BLACK);
		l4.setBounds(10,155,80,40);
		f3.setBorder(border);
		f3.setBounds(90,160,100,30);
		f3.setEditable(false);
		jPanel2.add(l2);
		jPanel2.add(f1);
		jPanel2.add(l3);
		jPanel2.add(f2);
		jPanel2.add(l4);
		jPanel2.add(f3);
		c.add(jPanel2);
		
		JPanel jPanel3=new JPanel();
		detail=new JButton("详细信息");
		close=new JButton("关  闭");
		Font fontBtn=new Font("黑体", Font.PLAIN, 15);
		jPanel3.setLayout(null);
		jPanel3.setBackground(Color.WHITE);
		jPanel3.setBounds(50,300,300,300);
		detail.setFont(fontBtn);
		detail.setBounds(0,50,100,30);
		detail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("详细信息")){
					dispose();
					new DetailedFOM();
				}
			}
		});
		close.setFont(fontBtn);
		close.setBounds(200,50,100,30);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("关  闭")){
					dispose();
					new CheckFrame();
				}
			}
		});
		jPanel3.add(detail);
		jPanel3.add(close);
		c.add(jPanel3);
		
		JPanel jPanel4=new JPanel();//这里用来放员工照片
		jPanel4.setLayout(null);
		jPanel4.setBackground(Color.WHITE);
		jPanel4.setBounds(240,40,500,500);
		JLabel testLocation=new JLabel();//位置调试成功，new ImageIcon(),使用IO流获取对应的员工照片
//		testLocation.setIcon(new ImageIcon("src/image/"+idtxt+".jpg"));
		testLocation.setIcon(new ImageIcon(img));
		System.out.println("src/image/"+idtxt+".jpg");
		testLocation.setBounds(30,50,200,170);//照片的bounds可能要重新调试
		jPanel4.add(testLocation);
		c.add(jPanel4);
		
		this.setTitle("粗略信息");//后期改！
		this.setSize(450,500);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Object[] info = new Object[4];
//		String idtxt = CheckFrame.getf1();
		System.out.println(idtxt);
		String sql = "select * from staff where workid="+idtxt+"";
		try {
			ResultSet rs=DataConnect.getStat().executeQuery(sql);
			if(rs.next()){
				info[0] = rs.getInt(1);
				info[1] = rs.getString(3);
				info[2] = rs.getString(7);
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
	}
	
	public static void main(String[] args) {
		new RoughFOM();
	}

}
