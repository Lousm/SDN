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
	// 从数据库中取值为UserBean的username赋值
	public String uname() throws Exception {
		ResultSet rs = Conn.getResultSet("select * from user");
		String username = null;
		while (rs.next()) {
			// int empno = rs.getInt(1);// 通过列编号来获取该列的值
			username = rs.getString("username");// 通过列名称来获取该列的值
		}
		return username;
	}

	// 从数据库中取值为UserBean的password赋值
	public String paw() throws Exception {
		ResultSet rs = Conn.getResultSet("select * from user");
		String password = null;
		while (rs.next()) {
			// int empno = rs.getInt(1);// 通过列编号来获取该列的值
			password = rs.getString("password");// 通过列名称来获取该列的值
		}
		// userbean.setPassword(password);
		return password;
	}

	// 为控制器各个属性赋值
	public int Cnumber() throws Exception {
		// 控制器的编号
		ResultSet rs = Conn.getResultSet("select * from controller");
		int number = rs.getRow();
		return number;
	}

	public int Cxcoord(int cx) {
		/*
		 * 取从a到b的随机数就是（int）（（b-a)*Math.random()＋a） 随机产生控制器的x坐标 具体的范围，以后根据窗体来设置
		 */
		int a = 160;
		/*int xcoord = rnd.nextInt(a);
		int b = (int) (99 * Math.random() + 1); */
		return cx;
	}

	public int Cycoord(int cy) {
		/*
		 * 随机产生控制器的坐标 具体的范围，以后根据窗体来设置
		 */
		int a = 160;
		//int ycoord = rnd.nextInt(a);

		return cy;
	}

	public int Cradius() {
		/*
		 * 产生控制器的半径 半径是可控制的。不是随机。目前先随机产生半径
		 */
		//int cradius = (int) (20 * Math.random() + 50);
		int a = 140;
		return a;
	}

	/*
	 * 为节点各个属性赋值
	 */
	public int Nxcoord() {
		/*
		 * 取从a到b的随机数就是（int）（（b-a)*Math.random()＋a） 随机产生节点的x坐标 具体的范围，以后根据窗体来设置
		 */
		int a = 1000;
		int xcoord = rnd.nextInt(a);
		
		return xcoord;
	}

	public int Nycoord() {
		/*
		 * 随机产生节点的坐标 具体的范围，以后根据窗体来设置
		 */
		int a = 600;
		int ycoord = rnd.nextInt(a);
		return ycoord;
	}

	public int NCnumber() {
		int a = 1;
		// 父控制器的编号
		return 5;
	}

	public int Nenergy() {
		// 电量，根据每个轮次递减
		int energy = 100;

		return 0;
	}

	public String Nstate(int b) {
		String[] a = { "激活", "休眠", "死亡" };
		String state;
		//int b = 1;// 从jsp获取的节点状态
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
		int a = 1;// 轮次。从jsp获得
		return a;
	}

	// 获取节点x坐标
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

	// 获取节点y坐标
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
	
	// 获取控制器x坐标
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

		// 获取节点y坐标
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
		
		//得到节点表长度
		public int setNlength() throws Exception{
			String sql = "SELECT * FROM node";
			int Nlength = 0;
			ResultSet rs = Conn.getResultSet(sql);
			while (rs.next()) {
				Nlength = rs.getRow();
			}
			return Nlength;
		}
		
		//得到控制器表长度
		public int setClength() throws Exception{
			String sql = "SELECT * FROM controller";
			int Clength = 0;
			ResultSet rs = Conn.getResultSet(sql);
			while (rs.next()) {
				Clength = rs.getRow();
			}
			return Clength;
		}


	// 计算两点之间的距离
	public void distance() throws Exception {
		int nx = setNxcoord(1);
		int ny = setNycoord(1);
		int cx = setCxcoord(1);
		int cy = setCycoord(1);

		//Connection con = Conn.getConnection();

		Point p1 = new Point(nx, ny);// 定义第一个点的坐标(5,5),或者你自己设置x,y坐标
		Point p2 = new Point(cx, cy);// 定义第一个点的坐标(5,5),或者你自己设置x,y坐标
		// 两点间距离
		double jili = Math.sqrt(Math.abs((p1.getX() - p2.getX())
				* (p1.getX() - p2.getX()) + (p1.getY() - p2.getY())
				* (p1.getY() - p2.getY())));
		System.out.println("两点间的距离是:" + jili);
	}

	@Test
	public void fun1() throws Exception {
		ResultSet rs = Conn.getResultSet("select * from user");
		String username = null;
		while (rs.next()) {
			// int empno = rs.getInt(1);// 通过列编号来获取该列的值
			username = rs.getString("username");// 通过列名称来获取该列的值
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
