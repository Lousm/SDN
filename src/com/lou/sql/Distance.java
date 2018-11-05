package com.lou.sql;

import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.lou.javabean.DistanceBean;
import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;

public class Distance {
	UserBean userbean = new UserBean();
	Set set = new Set();
	DistanceBean disbean = new DistanceBean();
	
	private static String sql1 = "SELECT * FROM controller";
	private static String sql2 = "SELECT * FROM node";
	private static String sql3 = "INSERT INTO distance(nid,cid,dis) VALUES (?,?,?)";
	
	public void info() throws Exception{
		Connection con = Conn.getConnection();
		int nx = 0;
		int ny = 0;
		int cx = 0;
		int cy = 0;
		/*
		 *�õ�node��ĳ�����Ϊ��ѭ��
		 *	�õ�controller��ĳ�����Ϊ��ѭ��
		 *		���ֱ����ڵ㵽�����������ľ��룩
		 *			����ڵ��źͿ�������ţ����뱣�浽distance
		 */
		
		//�õ�node��ĳ�����Ϊ��ѭ��
		int Nlength = 0;
		ResultSet rs = Conn.getResultSet(sql2);
		while (rs.next()) {
			Nlength = rs.getRow();
		}
		rs.close();
		System.out.println(Nlength);
		
		//�õ�controller��ĳ�����Ϊ��ѭ��
		int Clength = 0;
		ResultSet rs1 = Conn.getResultSet(sql1);
		while (rs1.next()) {
			Clength = rs1.getRow();
		}
		rs1.close();
		System.out.println(Clength);
		
		//���ݱ�ŷֱ��ýڵ�Ϳ�����������
		for(int i = 1;i<=Nlength;i++){
			for(int j = 1;j<=Clength;j++){
				disbean.setNxcoord(set.setNxcoord(i));
				disbean.setNycoord(set.setNycoord(i));
				disbean.setDxcoord(set.setCxcoord(j));
				disbean.setDycoord(set.setCycoord(j));
				nx = disbean.getNxcoord();
				ny = disbean.getNycoord();
				cx = disbean.getDxcoord();
				cy = disbean.getDycoord();
				
				Point p1 = new Point(nx, ny);//����x,y����
				Point p2 = new Point(cx, cy);// ����x,y����
				// ��������
				double juli = Math.sqrt(Math.abs((p1.getX() - p2.getX())
						* (p1.getX() - p2.getX()) + (p1.getY() - p2.getY())
						* (p1.getY() - p2.getY())));
				
				//����ڵ��źͿ�������ţ����뱣�浽distance��
				PreparedStatement pstem = con.prepareStatement(sql3);
				pstem.setInt(1, i);
				pstem.setInt(2, j);
				pstem.setFloat(3, (float) juli);
				pstem.executeUpdate();
				
				pstem.close();
			}
			System.out.println("�Ѿ����㵽�� "+i+" ��");
		}
		System.out.println("����������������������ɡ�����������������������");
		con.close();
	}
	
	//ɾ�����е�ȫ����¼
		public void delete() throws Exception{
			String sql = "DELETE FROM distance";
			Connection con = Conn.getConnection();
			PreparedStatement pstem = con.prepareStatement(sql);
			pstem.executeUpdate();
			
			pstem.close();
			con.close();
		}
		
		//���ɾ����
		public void dist() throws Exception{
			delete();
			info();
		}
	
	
	@Test
	public void fun1() throws Exception{
		delete();
		info();
	}
	
}
