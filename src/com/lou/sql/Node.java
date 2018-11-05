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

		// 调用方法为节点各个属性赋值
		userbean.setNxcoord(set.Nxcoord());
		userbean.setNycoord(set.Nycoord());

		// 得到控制器各个属性赋值给sql语句
		pstem.setInt(1, userbean.getNxcoord());
		pstem.setInt(2, userbean.getNycoord());

		// 执行sql语句
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}

	// 删除表中的全部记录
	public void Ndelete() throws Exception {
		String sql = "DELETE FROM node";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}

	/*
	 * 重新设置主键 数据库表的自增主键ID号经过一段时间的添加与删除之后乱了，需要重新排列。 原理：删除原有的自增ID，重新建立新的自增ID。
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

	// 向表中添加记录
	public void Nadd(int Namount) throws Exception {
		/*
		 * 添加节点的数量，根据前台输入来控制！
		 * 
		 * 暂时测试~
		 */
		// int a = 60;//此参数应从jsp中获得
		for (int i = 1; i <= Namount; i++) {
			info();
			System.out.println("正在创建第 " + i + " 条数据");
		}
	}

	public void node(int Namount) throws Exception {
		Ndelete();
		setkey();
		Nadd(Namount);
	}
	
	// 生成各个表
	public void contor(int Namount) throws Exception {
		

		node(Namount);

		// 调用距离表生成方法
		dis.dist();

		// 调用生成轮次表的方法
		contr.tr();

		// 调用生产业务表的方法
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
			// int empno = rs.getInt(1);// 通过列编号来获取该列的值
			String username = rs.getString("username");
			String password = rs.getString("password");// 通过列名称来获取该列的值
			System.out.println(username + "," + password);
		}

	}

}
