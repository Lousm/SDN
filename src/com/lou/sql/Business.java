package com.lou.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;

public class Business {
	UserBean userbean = new UserBean();
	Set set = new Set();
	ControlTrun cont = new ControlTrun();
	private static String sql1 = "SELECT * FROM distance";
	private static String sql2 = "SELECT * FROM controller";
	private static String sql3 = "SELECT * FROM node";
	private static String sql4 = "INSERT INTO business (nid,cid) VALUES (?,?)";

	public void judgec() throws Exception {
		Connection con = Conn.getConnection();

		/*
		 * �õ�node��ĳ�����Ϊ��ѭ�� �õ�controller��ĳ�����Ϊ��ѭ�� ��������id��nid,cid���õ���Ӧ�ľ���(dis)
		 * �жϸþ����Ƿ�С�ڰ뾶�����С�ڣ���Ѷ�Ӧ��nid��cid���뵽buisness����
		 */

		// �õ�node��ĳ�����Ϊ��ѭ��
		int Nlength = 0;
		ResultSet rs = Conn.getResultSet(sql3);
		while (rs.next()) {
			Nlength = rs.getRow();
		}
		System.out.println(Nlength);

		// �õ�controller��ĳ�����Ϊ��ѭ��
		int Clength = 0;
		ResultSet rs1 = Conn.getResultSet(sql2);
		while (rs1.next()) {
			Clength = rs1.getRow();
		}
		System.out.println(Clength);

		// ��������id��nid,cid���õ���Ӧ�ľ���(dis)
		for (int i = 1; i <= Nlength; i++) {
			for (int j = 1; j <= Clength; j++) {
				String sql = "SELECT dis FROM distance WHERE nid=? AND cid=?";
				PreparedStatement pstem = con.prepareStatement(sql);
				pstem.setInt(1, i);
				pstem.setInt(2, j);
				ResultSet rs2 = pstem.executeQuery();

				double a = 0;
				while (rs2.next()) {
					a = Double.parseDouble(rs2.getString("dis"));
				}
				// �жϸþ����Ƿ�С�ڰ뾶�����С�ڣ���Ѷ�Ӧ��nid��cid���뵽buisness����
				if (a <= 140) {
					PreparedStatement pstem1 = con.prepareStatement(sql4);
					cont.updateCid(i, j);
					pstem1.setInt(1, i);
					pstem1.setInt(2, j);
					pstem1.executeUpdate();
					
					pstem1.close();
				}
				System.out.println("�� " + j + " ��������");
				
				rs2.close();
				pstem.close();
			}
		}
		
		rs.close();
		rs1.close();
		con.close();
	}

	// ɾ�����е�ȫ����¼
	public void delete() throws Exception {
		String sql = "DELETE FROM business";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}
	
	//����ҵ������
	public void setBusi(String conNum,String busi) throws Exception {
		String sql = "UPDATE business SET busi=? WHERE cid=?";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		
		int a = Integer.parseInt(conNum);
		
		pstem.setString(1, busi);
		pstem.setInt(2, a);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
		
	}
	
	// ����ҵ���
	public void busi() throws Exception {
		delete();
		judgec();
		cont.updateEnergy();//�ѵ���С����ļ�¼����Ϊ0
	}

	@Test
	public void fun1() throws Exception {
		delete();
		judgec();
		cont.updateEnergy();
	}
	public void fun2() throws Exception {
		
		cont.updateEnergy();
	}
}
