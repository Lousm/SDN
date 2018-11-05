package com.lou.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.junit.Test;

import com.lou.test.Conn;

public class Trun {
	private static String sql1 = "INSERT INTO trun (nid,xcoord,ycoord,tru,energy) VALUES (?,?,?,?,?)";
	private static String sql2 = "SELECT * FROM node";
	private static String sql3 = "SELECT * FROM node WHERE number=?";
	private static String sql4 = "UPDATE trun SET trun=? WHERE nid";
	Random rnd = new Random();

	int ener=100;

	public void info(int trun) throws Exception {
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql3);

		/*
		 * 取出节点的number,xcoord,ycoord 放入trun表
		 */
		// 得到node表的长度作为外循环
		int Nlength = 0;
		ResultSet rs = Conn.getResultSet(sql2);
		while (rs.next()) {
			Nlength = rs.getRow();
		}
		//System.out.println(Nlength);

		for (int i = 1; i <= Nlength; i++) {
			pstem.setInt(1, i);
			ResultSet rs1 = pstem.executeQuery();

			int nx = 0;
			int ny = 0;
			while (rs1.next()) {
				nx = Integer.parseInt(rs1.getString("xcoord"));
				ny = Integer.parseInt(rs1.getString("ycoord"));
			}
			PreparedStatement pstem1 = con.prepareStatement(sql1);
			pstem1.setInt(1, i);
			pstem1.setInt(2, nx);
			pstem1.setInt(3, ny);
			pstem1.setInt(4, trun);
			pstem1.setInt(5, sel(i,trun));
			pstem1.executeUpdate();
			
			rs1.close();
			pstem1.close();
		}
		rs.close();
		pstem.close();
		con.close();
	}
	
	//查询上次电量结果集
	public int sel(int nid,int trun) throws Exception{
		int b=0;
		int c=0;
		
		if(trun==1){
			b=100;
		}
		else{
			String sql = "SELECT energy FROM trun WHERE nid=? AND tru=?";
			String sql1 = "SELECT srand FROM trun WHERE nid=? AND tru=?";
			Connection con = Conn.getConnection();
			PreparedStatement pstem = con.prepareStatement(sql);
			PreparedStatement pstem1 = con.prepareStatement(sql1);
//			System.out.println(nid+"---"+trun);
			pstem.setInt(1, nid);
			pstem.setInt(2, trun-1);
			ResultSet rs = pstem.executeQuery();
			
			pstem1.setInt(1, nid);
			pstem1.setInt(2, trun-1);
			ResultSet rs1 = pstem1.executeQuery();
			while (rs1.next()) {
				c=Integer.parseInt(rs1.getString("srand"));
			}
			if(c==1){
				while (rs.next()) {
					int a = rnd.nextInt(3);
					b=Integer.parseInt(rs.getString("energy"))-a;
				}
			}
			else if(c==0){
				int a = (int) (2 * Math.random() + 3);
				while (rs.next()) {
					b=Integer.parseInt(rs.getString("energy"))-a;
				}
			}
			else{
				while (rs.next()) {
					b=0;
				}
			}
			rs.close();
			rs1.close();
			pstem.close();
			pstem1.close();
			con.close();
			
		}
		//返回电量用于判断节点是否死亡
		
		return b;
	}
	
	//产生电量
		public int energy(int i){
			int b = 0;
			int a = rnd.nextInt(6);
			if(i==1){
				b=100;
			}
			else{
				b=ener-a;
			}
			return b;
		}
		
	// 删除表中的全部记录
	public void delete() throws Exception {
		String sql = "DELETE FROM trun";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}

	@Test
	public void fun1() throws Exception {
		delete();
		info(3);
	}
	public void fun2() throws Exception {
	
		//info();
	}

}
