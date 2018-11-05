package com.lou.javabean;

import org.junit.Test;

public class UserBean {
	private String username;
	private String password;
	
	//生成控制器坐标
	private int Cnumber;
	private int Cxcoord;
	private int Cycoord;
	private int Cradius;
	
	//生成节点坐标
	private int Nxcoord;
	private int Nycoord;
	private int NCnumber;
	private int Nenergy;
	private String Nstate;
	private int Nreihum;
	
	//计算距离坐标
	private int xcoord;
	private int ycoord;
	
	private int distance ;
	
	//生成距离表 （属性）
	private int Dxcoord;
	private int Dycoord;
	private int Ddis;
	
	//得到表长
	private int Nlength;
	private int Clength;
	
	public int getDxcoord() {
		return Dxcoord;
	}



	public int getNlength() {
		return Nlength;
	}



	public void setNlength(int nlength) {
		Nlength = nlength;
	}



	public int getClength() {
		return Clength;
	}



	public void setClength(int clength) {
		Clength = clength;
	}



	public void setDxcoord(int dxcoord) {
		Dxcoord = dxcoord;
	}



	public int getDycoord() {
		return Dycoord;
	}



	public void setDycoord(int dycoord) {
		Dycoord = dycoord;
	}



	public int getDdis() {
		return Ddis;
	}



	public void setDdis(int ddis) {
		Ddis = ddis;
	}



	public int getXcoord() {
		return xcoord;
	}



	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}



	public int getYcoord() {
		return ycoord;
	}



	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}



	public UserBean() {
	}



	public int getDistance() {
		return distance;
	}



	public void setDistance(int distance) {
		this.distance = distance;
	}



	public int getNxcoord() {
		return Nxcoord;
	}



	public void setNxcoord(int nxcoord) {
		Nxcoord = nxcoord;
	}



	public int getNycoord() {
		return Nycoord;
	}



	public void setNycoord(int nycoord) {
		Nycoord = nycoord;
	}



	public int getNCnumber() {
		return NCnumber;
	}



	public void setNCnumber(int nCnumber) {
		NCnumber = nCnumber;
	}



	public int getNenergy() {
		return Nenergy;
	}



	public void setNenergy(int nenergy) {
		Nenergy = nenergy;
	}



	public String getNstate() {
		return Nstate;
	}



	public void setNstate(String nstate) {
		Nstate = nstate;
	}



	public int getNreihum() {
		return Nreihum;
	}



	public void setNreihum(int Nreihum) {
		this.Nreihum = Nreihum;
	}



	public int getCnumber() {
		return Cnumber;
	}

	public void setCnumber(int cnumber) {
		this.Cnumber = cnumber;
	}

	public int getCxcoord() {
		return Cxcoord;
	}

	public void setCxcoord(int cxcoord) {
		this.Cxcoord = cxcoord;
	}

	public int getCycoord() {
		return Cycoord;
	}

	public void setCycoord(int cycoord) {
		this.Cycoord = cycoord;
	}

	public int getCradius() {
		return Cradius;
	}

	public void setCradius(int cradius) {
		this.Cradius = cradius;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Test
	public void fun1() throws Exception {
		/*
		 * ResultSet rs = Conn.getResultSet("select * from user"); String
		 * username = null; String password = null; while (rs.next()) { //int
		 * empno = rs.getInt(1);// 通过列编号来获取该列的值 username =
		 * rs.getString("username"); password = rs.getString("password");//
		 * 通过列名称来获取该列的值 System.out.println(username + "," + password ); }
		 * this.username=username; System.out.println(this.username);
		 */

		System.out.println(getUsername());
	}
}
