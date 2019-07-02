package dao;

import java.sql.*;

import javax.naming.InitialContext;

public class DataConnect {
	private static Statement stat;
	private static Connection con;
	private static void init() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/eploymanage?user=你的用户名&password=你的密码";
		Connection con=DriverManager.getConnection(url);
		stat=con.createStatement();
		url="use eploymanage";
		stat.executeUpdate(url);
		System.out.println("ok");
	}
	
	public static Statement getStat() throws ClassNotFoundException,SQLException{
		if(stat==null)
			init();
		return stat;
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/eploymanage?user=你的用户名&password=你的密码";
		con = DriverManager.getConnection(url);
		return con;
}
	
	public static void closeConn(Connection conn){
		if (null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭连接失败！");
				e.printStackTrace();
			}
		}
	}
}