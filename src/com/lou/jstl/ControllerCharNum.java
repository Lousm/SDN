package com.lou.jstl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.lou.test.Conn;

public class ControllerCharNum {
	private static String sql = "SELECT cid FROM business";
	public int getContorllerNum1() throws Exception{
		int cid1 = 0;

		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		ResultSet rs = pstem.executeQuery();
		
		while (rs.next()) {
			int cid = rs.getInt(1);
			if(cid==1){
				cid1++;
			}
		}
		
		pstem.close();
		con.close();
		return cid1;
	}
	
	public int getContorllerNum2() throws Exception{
		int cid2 = 0;

		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		ResultSet rs = pstem.executeQuery();
		
		while (rs.next()) {
			int cid = rs.getInt(1);
			if(cid==1){
				cid2++;
			}
		}

		pstem.close();
		con.close();
		return cid2;
	}
	
	public int getContorllerNum3() throws Exception{
		int cid3 = 0;

		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		ResultSet rs = pstem.executeQuery();
		
		while (rs.next()) {
			int cid = rs.getInt(1);
			if(cid==1){
				cid3++;
			}
		}
	
		pstem.close();
		con.close();
		return cid3;
	}
	
	public int getContorllerNum4() throws Exception{
		int cid4 = 0;

		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		ResultSet rs = pstem.executeQuery();
		
		while (rs.next()) {
			int cid = rs.getInt(1);
			if(cid==1){
				cid4++;
			}
		}
	
		pstem.close();
		con.close();
		return cid4;
	}
	
	@Test
	public void fun1() throws Exception{
		getContorllerNum1();
	}
}
