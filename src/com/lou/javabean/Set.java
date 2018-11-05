package com.lou.javabean;

import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.junit.Test;



import com.lou.test.Conn;

public class Set {
	UserBean userbean = new UserBean();
	Random rnd = new Random();
	//private static String sql = "SELECT xcoord FROM node WHERE number=?";
	// �����ݿ���ȡֵΪUserBean��username��ֵ
	public String uname() throws Exception {
		ResultSet rs = Conn.getResultSet("select * from user");
		String username = null;
		while (rs.next()) {
			// int empno = rs.getInt(1);// ͨ���б������ȡ���е�ֵ
			username = rs.getString("username");// ͨ������������ȡ���е�ֵ
		}
		return username;
	}

	// �����ݿ���ȡֵΪUserBean��password��ֵ
	public String paw() throws Exception {
		ResultSet rs = Conn.getResultSet("select * from user");
		String password = null;
		while (rs.next()) {
			// int empno = rs.getInt(1);// ͨ���б������ȡ���е�ֵ
			password = rs.getString("password");// ͨ������������ȡ���е�ֵ
		}
		// userbean.setPassword(password);
		return password;
	}

	// Ϊ�������������Ը�ֵ
	public int Cnumber() throws Exception {
		// �������ı��
		ResultSet rs = Conn.getResultSet("select * from controller");
		int number = rs.getRow();
		return number;
	}

	public int Cxcoord(int cx) {
		/*
		 * ȡ��a��b����������ǣ�int������b-a)*Math.random()��a�� ���������������x���� ����ķ�Χ���Ժ���ݴ���������
		 */
		int a = 160;
		/*int xcoord = rnd.nextInt(a);
		int b = (int) (99 * Math.random() + 1); */
		return cx;
	}

	public int Cycoord(int cy) {
		/*
		 * ������������������� ����ķ�Χ���Ժ���ݴ���������
		 */
		int a = 160;
		//int ycoord = rnd.nextInt(a);

		return cy;
	}

	public int Cradius() {
		/*
		 * �����������İ뾶 �뾶�ǿɿ��Ƶġ����������Ŀǰ����������뾶
		 */
		//int cradius = (int) (20 * Math.random() + 50);
		int a = 140;
		return a;
	}

	/*
	 * Ϊ�ڵ�������Ը�ֵ
	 */
	public int Nxcoord() {
		/*
		 * ȡ��a��b����������ǣ�int������b-a)*Math.random()��a�� ��������ڵ��x���� ����ķ�Χ���Ժ���ݴ���������
		 */
		int a = 1000;
		int xcoord = rnd.nextInt(a);
		
		return xcoord;
	}

	public int Nycoord() {
		/*
		 * ��������ڵ������ ����ķ�Χ���Ժ���ݴ���������
		 */
		int a = 600;
		int ycoord = rnd.nextInt(a);
		return ycoord;
	}

	public int NCnumber() {
		int a = 1;
		// ���������ı��
		return 5;
	}

	public int Nenergy() {
		// ����������ÿ���ִεݼ�
		int energy = 100;

		return 0;
	}

	public String Nstate(int b) {
		String[] a = { "����", "����", "����" };
		String state;
		//int b = 1;// ��jsp��ȡ�Ľڵ�״̬
		switch (b) {
		case 0:
			state = a[0];
			break;
		case 1:
			state = a[1];
			break;
		default:
			state = a[2];
			break;
		}
		return state;
	}

	public int Nreihum() {
		int a = 1;// �ִΡ���jsp���
		return a;
	}

	// ��ȡ�ڵ�x����
	public int setNxcoord(int x) throws Exception {
		Connection con = Conn.getConnection();
		String sql = "SELECT xcoord FROM node WHERE number=?";
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.setInt(1,x);
		ResultSet rs = pstem.executeQuery();
		int a = 0;
		while (rs.next()) {
			a = Integer.parseInt(rs.getString("xcoord"));
		}
		return a;
	}

	// ��ȡ�ڵ�y����
	public int setNycoord(int y) throws Exception {
		Connection con = Conn.getConnection();
		String sql = "SELECT ycoord FROM node WHERE number=?";
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.setInt(1,y);
		ResultSet rs = pstem.executeQuery();
		int a = 0;
		while (rs.next()) {
			a = Integer.parseInt(rs.getString("ycoord"));
		}
		return a;
	}
	
	// ��ȡ������x����
		public int setCxcoord(int x) throws Exception {
			Connection con = Conn.getConnection();
			String sql = "SELECT xcoord FROM controller WHERE number=?";
			PreparedStatement pstem = con.prepareStatement(sql);
			pstem.setInt(1,x);
			ResultSet rs = pstem.executeQuery();
			int a = 0;
			while (rs.next()) {
				a = Integer.parseInt(rs.getString("xcoord"));
			}
			return a;
		}

		// ��ȡ�ڵ�y����
		public int setCycoord(int y) throws Exception {
			Connection con = Conn.getConnection();
			String sql = "SELECT ycoord FROM controller WHERE number=?";
			PreparedStatement pstem = con.prepareStatement(sql);
			pstem.setInt(1,y);
			ResultSet rs = pstem.executeQuery();
			int a = 0;
			while (rs.next()) {
				a = Integer.parseInt(rs.getString("ycoord"));
			}
			return a;
		}
		
		//�õ��ڵ����
		public int setNlength() throws Exception{
			String sql = "SELECT * FROM node";
			int Nlength = 0;
			ResultSet rs = Conn.getResultSet(sql);
			while (rs.next()) {
				Nlength = rs.getRow();
			}
			return Nlength;
		}
		
		//�õ�����������
		public int setClength() throws Exception{
			String sql = "SELECT * FROM controller";
			int Clength = 0;
			ResultSet rs = Conn.getResultSet(sql);
			while (rs.next()) {
				Clength = rs.getRow();
			}
			return Clength;
		}


	// ��������֮��ľ���
	public void distance() throws Exception {
		int nx = setNxcoord(1);
		int ny = setNycoord(1);
		int cx = setCxcoord(1);
		int cy = setCycoord(1);

		//Connection con = Conn.getConnection();

		Point p1 = new Point(nx, ny);// �����һ���������(5,5),�������Լ�����x,y����
		Point p2 = new Point(cx, cy);// �����һ���������(5,5),�������Լ�����x,y����
		// ��������
		double jili = Math.sqrt(Math.abs((p1.getX() - p2.getX())
				* (p1.getX() - p2.getX()) + (p1.getY() - p2.getY())
				* (p1.getY() - p2.getY())));
		System.out.println("�����ľ�����:" + jili);
	}

	@Test
	public void fun1() throws Exception {
		ResultSet rs = Conn.getResultSet("select * from user");
		String username = null;
		while (rs.next()) {
			// int empno = rs.getInt(1);// ͨ���б������ȡ���е�ֵ
			username = rs.getString("username");// ͨ������������ȡ���е�ֵ
		}
		userbean.setUsername(username);
		System.out.println(userbean.getUsername());
		/*
		 * int b = (int) (99 * Math.random() + 1); System.out.println(b); int
		 * xcoord = rnd.nextInt(100); System.out.println(xcoord);
		 */
		System.out.println(Cradius());
	}
	
	@Test
	public void fun2() throws Exception{
		System.out.println(setNxcoord(2));
		System.out.println(setNycoord(2));
		System.out.println(setCxcoord(2));
		System.out.println(setCycoord(2));
		//distance();
	}
	
	@Test
	public void fun3(){
		int b = (int) (2 * Math.random() + 3);
		System.out.println(b);
	}

}
