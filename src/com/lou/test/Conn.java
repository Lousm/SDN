package com.lou.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//���ݷ��ʲ㣬��ȡ���ݿ�����
public class Conn {
	private static final String url = "jdbc:mysql://localhost:3306/java1?useUnicode=true&characterEncoding=utf8" ;
	private static final String username = "root" ;
	private static final String password = "123456" ;
	static{
		String driver = "com.mysql.jdbc.Driver" ; 
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void fun1() {
		
		
	}

	//����con����
	public static Connection getConnection() throws Exception{
		
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
	//����stem����
	public static Statement getStatement() throws Exception{
		Connection con = getConnection();
		Statement stem = con.createStatement();
		return stem;
	}
	
	//����rs����
	public static ResultSet getResultSet(String sql) throws Exception{
		Statement stem = getStatement();
		ResultSet rs = stem.executeQuery(sql);
		return rs;
	}
	
	
	
}
