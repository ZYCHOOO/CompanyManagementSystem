package view;

import java.awt.*;  
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;  
import javax.swing.border.*;

import dao.ModelFactory;
import domain.Admin;
import domain.Staff;   
  
public class Login extends JFrame {
	
	private JLabel l1,l2,l3;
	private static JTextField name;
	private JPasswordField pass;
	private JButton login,register;
	private JRadioButton staff,admin;
      
//    public static final String USERNAME = "admin" ;  
//    public static final String PASSWORD = "admin" ;  
      
    public Login() {  
        Container c = this.getContentPane();  
        c.setBackground(Color.WHITE);  
        c.setLayout(null);  
        c.addKeyListener(new KeyAdapter() {  
            public void keyReleased(KeyEvent paramKeyEvent) {  
                // TODO Auto-generated method stub  
                if (paramKeyEvent.getKeyCode()==paramKeyEvent.VK_ENTER) {  
                    dispose();  
                    new AdminFrame();  
                }else {  
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);  
                }  
            }  
        });  
  
          
        JPanel jPanel1 = new JPanel();
        JLabel l1 = new JLabel("员工管理系统", JLabel.CENTER);  
        Font font = new Font("华文彩云", Font.PLAIN, 30);    
        l1.setFont(font);  
        l1.setForeground(Color.BLUE);  
        jPanel1.setLayout(new BorderLayout());    
        jPanel1.setBackground(Color.WHITE);  
        jPanel1.setBounds(10, 5, 300, 50);   
        jPanel1.add(l1, BorderLayout.SOUTH);  
        c.add(jPanel1);  
          
        JPanel jPanel2 = new JPanel();  
        Font fontText = new Font("幼圆", Font.PLAIN, 20);  
        Border border = new MatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY);  
        jPanel2.setLayout(null);  
        jPanel2.setBackground(Color.WHITE);  
        jPanel2.setBounds(5, 80, 300, 50);  
        JLabel l2 = new JLabel("账  号：");  
        l2.setFont(fontText);  
        l2.setBounds(10,5,80,40);  
        name= new JTextField();  
        name.setBorder(border);  
        name.setBounds(90,10,200,30);  
        name.setFont(fontText);  
        jPanel2.add(l2);  
        jPanel2.add(name);  
        c.add(jPanel2);  
          
        JPanel jPanel3 = new JPanel();  
        Font fontPassword = new Font("幼圆", Font.PLAIN, 20);  
        jPanel3.setLayout(null);  
        jPanel3.setBackground(Color.WHITE);  
        jPanel3.setBounds(5, 140, 300, 50);  
        JLabel l3 = new JLabel("密  码：");  
        l3.setFont(fontPassword);  
        l3.setBounds(10,5,80,40);  
        pass= new JPasswordField();  
        pass.setEchoChar('*');  
        pass.setBorder(border);  
        pass.setBounds(90,10,200,30);  
        pass.setFont(fontPassword);  
        jPanel3.add(l3);  
        jPanel3.add(pass);  
        c.add(jPanel3);   
        
        staff=new JRadioButton("员工");
        staff.setBounds(70, 200, 100, 35);
        Font RdBtnFont=new Font("幼圆", Font.PLAIN, 20);
        staff.setFont(RdBtnFont);
        staff.setBackground(Color.WHITE);
        c.add(staff);
        
        admin=new JRadioButton("管理员");
        admin.setBounds(180,200,100,35);
        admin.setFont(RdBtnFont);
        admin.setBackground(Color.WHITE);
        c.add(admin);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(staff);
        bg.add(admin);
          
        login= new JButton("登陆");  
        login.setBounds(50, 240, 100, 35);
        Font BtnFont = new Font("幼圆", Font.PLAIN, 20);
        login.setFont(BtnFont);  
        login.setBackground(Color.WHITE);  
        login.addActionListener(new ActionListener() {  
              
            @Override  
            public void actionPerformed(ActionEvent paramActionEvent) {  
                // TODO Auto-generated method stub  
//                String box1 = name.getText();  
//                String box2 = new String(pass.getPassword());  
//                if (box1.equals(USERNAME)&&box2.equals(PASSWORD)) { 
            	if(admin.isSelected()){
            		Admin ad;
            		try {
            			ad = ModelFactory.alogin(Integer.parseInt(name.getText()),pass.getText());
            			if(ad!=null){
            				dispose();  
            				new AdminFrame();  
            			}else {  
            				JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);  
            			}
            		} catch (NumberFormatException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		} catch (ClassNotFoundException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		} catch (SQLException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
				}
            	}else if(staff.isSelected()){
            		Staff sf;
            		try {
            			sf = ModelFactory.slogin(Integer.parseInt(name.getText()),pass.getText());
            			if(sf!=null){
            				dispose();  
            				new StaffFrame();  
            			}else {  
            				JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);  
            			}
            		} catch (NumberFormatException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		} catch (ClassNotFoundException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		} catch (SQLException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
				}
            	}
            	}  
        	});  
        c.add(login);
        
        register=new JButton("注册");
        register.setBounds(180,240,100,35);
        register.setFont(BtnFont);
        register.setBackground(Color.WHITE);
        register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new RegisterFrame();
				
			}
		});
        c.add(register);
          
          
          
        this.setTitle("登陆界面"); //setTiltle到时需要改名字 
        this.setSize(320, 340);  
        this.setVisible(true);  
        this.setResizable(false);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
    
    public static String getname(){
    	return name.getText();
    }
    
    public static void main(String[] args) {
		new Login();
	}


}