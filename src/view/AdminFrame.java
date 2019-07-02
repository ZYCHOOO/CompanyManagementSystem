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
        l1=new JLabel("Ա �� �� �� ϵ ͳ",JLabel.CENTER);
        Font font=new Font("���Ĳ���", Font.PLAIN, 30);//������ʽ�������
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
        JTextArea jTextArea=new JTextArea("��ӭ��½�������ǣ�"+strDate);//jTextArea����ɫ�������ã������ܸĵĻ�Ҫ�޸�
        jTextArea.append("\n");
        jTextArea.append("����ʱ���ǣ�"+strTime);
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        Border border=new MatteBorder(1,1,1,1,Color.LIGHT_GRAY);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEnabled(false);//�� �ı����ڲ��ܼ����ַ�����
        jTextArea.setFont(new Font("��Բ", Font.PLAIN, 20));
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setBackground(Color.WHITE);
        jScrollPane.setBorder(border);
        jScrollPane.setBounds(30,85,400,200);
        c.add(jScrollPane);
        
        JPanel jPanel3=new JPanel();
        jPanel3.setBackground(Color.WHITE);
        jPanel3.setBounds(30, 300, 400, 165);
        Font fontButton=new Font("��Բ", Font.PLAIN, 22);
        jPanel3.setLayout(new GridLayout(5,1,0,5));
        
        insert=new JButton("���Ա����Ϣ");
        insert.setFont(fontButton);
        insert.setBackground(Color.WHITE);
        insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("���Ա����Ϣ")){
					dispose();
					new InsertFrame();
				}
			}
		});
        jPanel3.add(insert);
        
        delete=new JButton("ɾ��Ա����Ϣ");
        delete.setFont(fontButton);
        delete.setBackground(Color.WHITE);
        delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("ɾ��Ա����Ϣ")){
					dispose();
					new DeleteFrame();
				}
			}
		});
        jPanel3.add(delete);
        
        check=new JButton("�鿴Ա����Ϣ");
        check.setFont(fontButton);
        check.setBackground(Color.WHITE);
        check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("�鿴Ա����Ϣ")){
					dispose();
					new CheckFrame();
				}
			}
		});
        jPanel3.add(check);
        
        alter=new JButton("�޸�Ա����Ϣ");
        alter.setFont(fontButton);
        alter.setBackground(Color.WHITE);
        alter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("�޸�Ա����Ϣ")){
					dispose();
					new AlterFrame();
				}
				
			}
		});
        jPanel3.add(alter);
        
        exit=new JButton("�˳�����ϵͳ");
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
        
        this.setTitle("������");//setTiltle��ʱ��Ҫ������ 
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
