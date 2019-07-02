package dao;

import java.sql.*;
import java.util.ArrayList;

import domain.Admin;
import domain.Staff;

public class ModelFactory {
	public static Admin alogin(int id,String password)throws SQLException,ClassNotFoundException{
		Admin ad=null;
		String sql="select * from admin where id='"+id+"' and password='"+password+"'";
		ResultSet rs = DataConnect.getStat().executeQuery(sql);
		if(rs.next())
			ad = new Admin(id, password);
		return ad;
	}
	
	public static Staff slogin(int workid,String staffpw)throws SQLException,ClassNotFoundException{
		Staff sf=null;
		String sql="select * from staff where workid='"+workid+"' and staffpw='"+staffpw+"'";
		ResultSet rs = DataConnect.getStat().executeQuery(sql);
		if(rs.next())
			sf = new Staff(workid, staffpw);
		return sf;
	}
	
	public static Admin regisad(int id,String password)throws SQLException,ClassNotFoundException{
		Admin ad=null;
		String sql="insert into admin(id,password) values('"+id+"','"+password+"')";
//		String sql = "insert into admin(username,password) values ('"+f1.getText()+"','"+p1.getText()+"')";
		int rs = DataConnect.getStat().executeUpdate(sql.toString());
//		if(rs.next())
//			ad = new Admin(id, password);
		return ad;
	}
	
//	public static Staff altersf(int workid,String staffpw)throws SQLException,ClassNotFoundException{
//		Staff sf=null;
//		String[] alter=new String[0];
//		String sql="update staff set staffpw='"+alter+"'";
//		String sql = "insert into admin(username,password) values ('"+f1.getText()+"','"+p1.getText()+"')";
//		int rs = DataConnect.getStat().executeUpdate(sql.toString());
//		if(rs.next())
//			ad = new Admin(id, password);
//		return sf;
//	}

	public static void insertInfo(int idtxt,String nametxt,String sextxt,long idcardtxt,String birthtxt,String educatxt,String positxt) throws ClassNotFoundException, SQLException{
	String sql = "insert into staff(workid,staffpw,name,sex,idcard,birth,position,education) values("+idtxt+","+idtxt+",'"+nametxt+"','"+sextxt+"',"
+idcardtxt+",'"+birthtxt+"','"+positxt+"','"+educatxt+"')";
		DataConnect.getStat().executeUpdate(sql);
}
		public static ResultSet searchid(int idtxt) throws ClassNotFoundException, SQLException{
			String sql = "select * from staff where workid="+idtxt+"";
			ResultSet rs=DataConnect.getStat().executeQuery(sql);
			return rs;
		}
}
