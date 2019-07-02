package dao;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.AlterFrame;
import view.CheckFrame;
import view.InsertFrame;
import view.ToAlter;

public class ImageDemo {
	
	public static void readImage2DB(){
	String itpath = InsertFrame.getpath();
	String alpath = ToAlter.getalpath();
	String path = null;
	if(itpath!=null){
		path=itpath;
	}
	else{
		path=alpath;
	}
	int itid = InsertFrame.getid();
//	int alid = Integer.parseInt(AlterFrame.getf1());
	int idtxt;
	if(itid!=0){
		idtxt=itid;
	}
	else{
		idtxt=Integer.parseInt(AlterFrame.getf1());
	}
	System.out.println(idtxt);
	Connection conn = null;
	PreparedStatement ps = null;
	FileInputStream in = null;
	try {
		in = ImageUtil.readImage(path);
		conn = DataConnect.getConnection();
		String sql = "update staff set perphoto=? where workid=?";
		ps = conn.prepareStatement(sql);
		ps.setBinaryStream(1, in, in.available());
		ps.setInt(2, idtxt);
		int count = ps.executeUpdate();
		if (count > 0){
			System.out.println("插入成功！");
		}else{
			System.out.println("插入失败！");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DataConnect.closeConn(conn);
	}
	if (null != ps){
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	public static void readDB2Image(){
		String idtxt = CheckFrame.getf1();
		String targetPath = "src/image/"+idtxt+".jpg";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataConnect.getConnection();
			String sql = "select * from staff where workid =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(idtxt));
			rs = ps.executeQuery();
			while (rs.next()){
				InputStream in = rs.getBinaryStream("perphoto");
				ImageUtil.readBin2Image(in, targetPath);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataConnect.closeConn(conn);
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
