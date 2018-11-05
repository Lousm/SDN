package com.lou.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;

public class ControlTrun {
	Set set = new Set();
	UserBean userbean = new UserBean();
	Random rnd = new Random();
	Trun trun = new Trun();
	private static String sql1 = "INSERT INTO trun (trun,state,srand) VALUES (?,?,?)";
	// 以节点编号
	private static String sql2 = "UPDATE trun SET state=?,srand=? WHERE nid=? AND tru=?";
	private static String sql3 = "UPDATE trun SET cid=? WHERE nid=?";
	private static String sql4 = "UPDATE trun SET buis=?,energy=?,state=?,srand=? WHERE nid=? AND tru=?";
	private static String sql5 = "SELECT nid,energy,tru FROM trun";
	int ener = 0;
	int nid = 0;
	int tru = 0;

	/*
	 * 添加轮次，电量，状态，和状态随机数 重点（在每个轮次添加之前，先添加一遍，节点信息） 以轮次作为外循环，以节点数量作为内循环，来添加
	 */

	// 控制轮次，电量，状态，和状态随机数
	public void info(int srand, int nid, int trun) throws Exception {
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql2);
		String str = set.Nstate(srand);
		pstem.setString(1, str);
		pstem.setInt(2, srand);
		pstem.setInt(3, nid);
		pstem.setInt(4, trun);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
		
		
		
	}

	// 得到当前电量判断是否死亡
	public void getEnergy(int energy) {
		ener = energy;
	}

	// 从接收节点编号和轮次的方法
	public void getNid(int nid, int tru) {
		this.nid = nid;
		this.tru = tru;
	}

	// 产生状态随机数
	public int srand() {
		// int energy = ener;
		int sra = 0;
		/*
		 * if (ener == 0){//如果电量为0 则节点死亡 sra = 2; } else {
		 * 
		 * }
		 */
		sra = rnd.nextInt(2);

		return sra;
	}

	// 得到上次节点状态随机数集合，如果上次结果为2，那以后该接节点都为2
	public int srand1() throws Exception {
		int sra = 0;
		int a = 0;
		int energy = ener;
		String sql = "SELECT srand FROM trun WHERE nid=? AND tru=?";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.setInt(1, nid);
		pstem.setInt(2, tru - 1);
		ResultSet rs = pstem.executeQuery();

		while (rs.next()) {
			a = Integer.parseInt(rs.getString("srand"));
		}

		if (ener == 0) {// 如果电量为0 则节点死亡
			sra = 2;
		} else {
			if (a == 2) {
				sra = 2;
			} else {
				sra = rnd.nextInt(2);
			}
		}
		return sra;
	}

	public void Tadd1() throws Exception {
		int a = 60;
		userbean.setNlength(set.setNlength());
		int nlength = userbean.getNlength();
		for (int i = 1; i <= a; i++) {
			trun.info(i);
			System.out.println("添加第 "+i+" 个轮次");

			for (int j = 1; j <= nlength; j++) {
				getNid(j, i);
				int sra = srand();
				info(sra, j, i);

			}
		}
		
	}
	
	// 更新energy,state,rand字段(电量小于等于0 全置energy为0，state为死亡，srand为2);
	public void updateEnergy() throws Exception{
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql4);
		PreparedStatement pstem1 = con.prepareStatement(sql5);
		ResultSet rs = pstem1.executeQuery();
		while (rs.next()) {
			int energy = rs.getInt(2);
			if(energy <= 0){
				int nid=rs.getInt(1);
				int tru=rs.getInt(3);
				
				pstem.setString(1, "(脱控)");
				pstem.setInt(2, 0);
				pstem.setString(3, "死亡");
				pstem.setInt(4, 2);
				pstem.setInt(5,nid);
				pstem.setInt(6,tru);
				pstem.executeUpdate();
				//System.out.println("已更新为"+energy);
			}
			else{ continue;}
			
		}
		System.out.println("——————已更新电量——————");
		
		pstem1.close();
		pstem.close();
		con.close();
	}
	

	// 更新cid字段
	public void updateCid(int nid, int cid) throws Exception {
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql3);

		pstem.setInt(1, cid);
		pstem.setInt(2, nid);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
		
		
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

	// 插入业务属性
	public void setBusi(String conNum, String busi) throws Exception {
		String sql = "UPDATE trun SET buis=? WHERE cid=?";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);

		int a = Integer.parseInt(conNum);
		String busi_=busi+"(受控)";

		pstem.setString(1, busi_);
		pstem.setInt(2, a);
		pstem.executeUpdate();
		System.out.println("更新轮次表的buis字段");
		
		pstem.close();
		con.close();
	}
	/*//关闭连接
		public void closs(){
			try {
				if (rs != null)
					rs.close();
				if (stem != null)
					stem.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}*/

	// 生成轮次表
	public void tr() throws Exception {
		delete();
		Tadd1();
		
	}

	@Test
	public void fun1() throws Exception {
		Tadd1();
		/*
		 * userbean.setNlength(set.setNlength()); int nlength =
		 * userbean.getNlength(); System.out.println(nlength);
		 */
	}

	@Test
	public void fun2() throws Exception {
		delete();
	}
	
	@Test
	public void fun3() throws Exception {
		updateEnergy();
	}
}
