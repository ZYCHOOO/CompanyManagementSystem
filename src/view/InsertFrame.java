package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

import dao.DataConnect;
import dao.ImageDemo;
import dao.ModelFactory;

public class InsertFrame extends JFrame{
	private JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField f1,f2,f3,f4,f5,f6,f7,f8,f9;
	private JButton create,confirm,cancel,addphoto;
	private String[] sex={"男","女"};
	private String[] qualification={"大专","本科","研究生"};
	private int count=0;
	private int count2=0;
	private static int id;
	private static String path;
	
	public InsertFrame(){
		Container c=this.getContentPane();
		c.setBackground(Color.WHITE);  
        c.setLayout(null);
        
        JPanel jPanel=new JPanel();
        l0=new JLabel("编 辑 员 工 信 息");
        Font font0=new Font("华文彩云", Font.PLAIN, 30);
        l0.setFont(font0);
        l0.setForeground(Color.BLUE);
        jPanel.setLayout(new BorderLayout());
        jPanel.setBackground(Color.WHITE);
        jPanel.setBounds(150,-30,360,70);
        jPanel.add(l0,BorderLayout.SOUTH);
        c.add(jPanel);
        
		JPanel jPanel1=new JPanel();
		l1=new JLabel("员工编号");
		f1=new JTextField(10);
		create=new JButton("生成编号");//使用随机生成8位员工ID的方法（随机生成数字）并判断是否重复
//		int[] id=new int[4];
//		for(int i=0;i<id.length;i++){
//			id[i]=(int)(Math.random()*100);
//		}
//		System.out.println("编号是"+id[0]+id[1]+id[2]+id[3]);
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
		f1.setEnabled(false);
//		f1.setText(String.valueOf(id[0]+id[1]+id[2]+id[3]+id[4]+id[5]+id[6]+id[7]));
		create.setFont(fontBtn1);
		create.setBackground(Color.WHITE);
		create.setBounds(200,10,100,30);
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					int maxNum=10;
					int i;
					int count=0;
					char[] idelement={'0','1','2','3','4','5','6','7','8','9'};
					StringBuffer sBuffer=new StringBuffer("");
					Random r=new Random();
					while(count<8){
						i=Math.abs(r.nextInt(maxNum));
						if(i>=0&&i<idelement.length){
							sBuffer.append(idelement[i]);
							count++;
						}
					}
					f1.setText(sBuffer.toString());
					System.out.println("生成编号"+sBuffer.toString());
			}
		});
		jPanel1.add(l1);
		jPanel1.add(f1);
		jPanel1.add(create);
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
		l3.setEnabled(false);
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
		jPanel4.setBounds(5,200,500,50);
		l4.setFont(font4);
		l4.setForeground(Color.BLACK);
		l4.setBounds(10,15,80,40);
		f4.setBorder(border4);
		f4.setBounds(90,20,150,30);
		jPanel4.add(l4);
		jPanel4.add(f4);
		c.add(jPanel4);
		
		JPanel jPanel5=new JPanel();
		l5=new JLabel("出生日期");//规定输入格式位yyyy-MM-dd，否则判断为非法字符（Simpledateformat）
		f5=new JTextField(20);
		Font font5=new Font("幼圆", Font.PLAIN, 20);
		Border border5=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
		jPanel5.setLayout(null);
		jPanel5.setBackground(Color.WHITE);
		jPanel5.setBounds(5,250,500,50);
		l5.setFont(font5);
		l5.setForeground(Color.BLACK);
		l5.setBounds(10,15,80,40);
		f5.setBorder(border5);
		f5.setBounds(90,20,150,30);
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
		l6.setEnabled(false);
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
		jPanel7.setBounds(5,350,500,50);
		l7.setFont(font7);
		l7.setForeground(Color.BLACK);
		l7.setBounds(15,15,80,40);
		f7.setBorder(border7);
		f7.setBounds(90,20,100,30);
		jPanel7.add(l7);
		jPanel7.add(f7);
		c.add(jPanel7);
		
		JPanel jPanel8=new JPanel();
		confirm=new JButton("保存");
		cancel=new JButton("取消");
		Font fontBtn2=new Font("黑体", Font.PLAIN, 20);
		jPanel8.setLayout(null);
		jPanel8.setBackground(Color.WHITE);
		jPanel8.setBounds(5,450,500,50);
		confirm.setFont(fontBtn2);
		confirm.setBounds(100,15,80,30);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("保存")){
//					String sql = "insert into staff values("+idtxt+",'"+nametxt+"','"+sextxt+"',"
//				+idcardtxt+",'"+birthtxt+"','"+positxt+"','"+educatxt+"')";
//						ResultSet rs = DataConnect.getStat().executeQuery(sql);
					setid(Integer.parseInt(f1.getText()));
					try {
						ModelFactory.insertInfo(Integer.parseInt(f1.getText()),f2.getText(),f3.getText(),Long.parseLong(f4.getText()),f5.getText(),f6.getText(),f7.getText());
						ImageDemo.readImage2DB();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "保存成功", " ", JOptionPane.PLAIN_MESSAGE);
					dispose();
					new AdminFrame();
				}
			}
		});
		cancel.setFont(fontBtn2);
		cancel.setBounds(400,15,80,30);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("取消")){
					int n=JOptionPane.showConfirmDialog(null, "是否取消编辑？"," ",JOptionPane.YES_NO_OPTION);
						if(n==JOptionPane.YES_OPTION){
							dispose();
							new AdminFrame();
						}else{
							dispose();
							new InsertFrame();
						}					
				}
			}
		});
		jPanel8.add(confirm);
		jPanel8.add(cancel);
		c.add(jPanel8);
		
		JPanel jPanel9=new JPanel();
		l8=new JLabel("照片设置为员工ID.jpg");//照片放置数据库有点小难，只能将照片设置为个人ID.jpg，然后用IO流读取照片，在查看员工信息中显示
		addphoto=new JButton("添加照片");
		Font font8=new Font("幼圆", Font.PLAIN, 10);
		jPanel9.setLayout(null);
		jPanel9.setBackground(Color.WHITE);
		jPanel9.setBounds(300,-40,600,600);
		addphoto.setFont(font8);
		addphoto.setBounds(100,120,100,150);
		addphoto.addActionListener(new ActionListener() {
			File f;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc=new JFileChooser();
				jfc.showOpenDialog(null);
				f=jfc.getSelectedFile();
				addphoto.setIcon(new ImageIcon(f.getAbsolutePath()));
				System.out.println(f.getAbsolutePath());
				setpath(f.getAbsolutePath());
			}
		});
		l8.setFont(font8);
		l8.setForeground(Color.BLACK);
		l8.setBounds(100,50,500,100);
		jPanel9.add(addphoto);
		jPanel9.add(l8);
		c.add(jPanel9);
		
		
		
		
		
		this.setTitle("添加信息");//此处setTitle需要最终修改
		this.setSize(550,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				//获取
//		String idtxt = f1.getText();
//		String nametxt = f2.getText();
//		String sextxt = f3.getText();
//		String idcardtxt = f4.getText();
//		String birthtxt = f5.getText();
//		String educatxt = f6.getText();
//		String positxt = f7.getText();
		
		
	}
	public void setpath(String path){
		this.path=path;
	}
	
	public static String getpath(){
		return path;
	}
	
	public void setid(int id){
		this.id=id;
	}
	
	public static int getid(){
		return id;
	}
	
	public static void main(String[] args) {
		new InsertFrame();
	}

}//ZYCHOOO COPYRIGHT
