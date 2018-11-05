package com.lou.sql;

import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;

public class Node {
	UserBean userbean = new UserBean();
	Set set = new Set();
	Distance dis = new Distance();
	Business busi = new Business();
	ControlTrun contr = new ControlTrun();
	private static String sql = "INSERT INTO node(xcoord,ycoord) VALUES (?,?)";

	public void info() throws Exception {
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);

		// ���÷���Ϊ�ڵ�������Ը�ֵ
		userbean.setNxcoord(set.Nxcoord());
		userbean.setNycoord(set.Nycoord());

		// �õ��������������Ը�ֵ��sql���
		pstem.setInt(1, userbean.getNxcoord());
		pstem.setInt(2, userbean.getNycoord());

		// ִ��sql���
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}

	// ɾ�����е�ȫ����¼
	public void Ndelete() throws Exception {
		String sql = "DELETE FROM node";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}

	/*
	 * ������������ ���ݿ�����������ID�ž���һ��ʱ��������ɾ��֮�����ˣ���Ҫ�������С� ԭ��ɾ��ԭ�е�����ID�����½����µ�����ID��
	 */
	public void setkey() throws Exception {
		Connection con = Conn.getConnection();
		String sql1 = "ALTER  TABLE node DROP number";
		String sql2 = "ALTER  TABLE node ADD number INT(8) NOT NULL  FIRST";
		String sql3 = "ALTER  TABLE node MODIFY COLUMN  number INT(8) NOT NULL  AUTO_INCREMENT,ADD PRIMARY  KEY(number)";
		PreparedStatement pstem1 = con.prepareStatement(sql1);
		PreparedStatement pstem2 = con.prepareStatement(sql2);
		PreparedStatement pstem3 = con.prepareStatement(sql3);
		pstem1.executeUpdate();
		pstem2.executeUpdate();
		pstem3.executeUpdate();
		
		pstem1.close();
		pstem2.close();
		pstem3.close();
		con.close();
	}

	// �������Ӽ�¼
	public void Nadd(int Namount) throws Exception {
		/*
		 * ��ӽڵ������������ǰ̨���������ƣ�
		 * 
		 * ��ʱ����~
		 */
		// int a = 60;//�˲���Ӧ��jsp�л��
		for (int i = 1; i <= Namount; i++) {
			info();
			System.out.println("���ڴ����� " + i + " ������");
		}
	}

	public void node(int Namount) throws Exception {
		Ndelete();
		setkey();
		Nadd(Namount);
	}
	
	// ���ɸ�����
	public void contor(int Namount) throws Exception {
		

		node(Namount);

		// ���þ�������ɷ���
		dis.dist();

		// ���������ִα�ķ���
		contr.tr();

		// ��������ҵ���ķ���
		busi.busi();

	}

	/*
	 * @Test public void fun3() throws Exception{ Nadd(); //a(); }
	 */

	@Test
	public void fun2() throws Exception {
		Ndelete();
		setkey();
		Nadd(120);
	}

	@Test
	public void fun1() throws Exception {
		Connection con = Conn.getConnection();
		System.out.println(con);
		// ResultSet rs = con.getStatement().executeQuery("select * from user");
		Statement stem = con.createStatement();
		ResultSet rs = stem.executeQuery("select * from user");

		while (rs.next()) {
			// int empno = rs.getInt(1);// ͨ���б������ȡ���е�ֵ
			String username = rs.getString("username");
			String password = rs.getString("password");// ͨ������������ȡ���е�ֵ
			System.out.println(username + "," + password);
		}

	}

}
