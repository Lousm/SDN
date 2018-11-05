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
	// �Խڵ���
	private static String sql2 = "UPDATE trun SET state=?,srand=? WHERE nid=? AND tru=?";
	private static String sql3 = "UPDATE trun SET cid=? WHERE nid=?";
	private static String sql4 = "UPDATE trun SET buis=?,energy=?,state=?,srand=? WHERE nid=? AND tru=?";
	private static String sql5 = "SELECT nid,energy,tru FROM trun";
	int ener = 0;
	int nid = 0;
	int tru = 0;

	/*
	 * ����ִΣ�������״̬����״̬����� �ص㣨��ÿ���ִ����֮ǰ�������һ�飬�ڵ���Ϣ�� ���ִ���Ϊ��ѭ�����Խڵ�������Ϊ��ѭ���������
	 */

	// �����ִΣ�������״̬����״̬�����
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

	// �õ���ǰ�����ж��Ƿ�����
	public void getEnergy(int energy) {
		ener = energy;
	}

	// �ӽ��սڵ��ź��ִεķ���
	public void getNid(int nid, int tru) {
		this.nid = nid;
		this.tru = tru;
	}

	// ����״̬�����
	public int srand() {
		// int energy = ener;
		int sra = 0;
		/*
		 * if (ener == 0){//�������Ϊ0 ��ڵ����� sra = 2; } else {
		 * 
		 * }
		 */
		sra = rnd.nextInt(2);

		return sra;
	}

	// �õ��ϴνڵ�״̬��������ϣ�����ϴν��Ϊ2�����Ժ�ýӽڵ㶼Ϊ2
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

		if (ener == 0) {// �������Ϊ0 ��ڵ�����
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
			System.out.println("��ӵ� "+i+" ���ִ�");

			for (int j = 1; j <= nlength; j++) {
				getNid(j, i);
				int sra = srand();
				info(sra, j, i);

			}
		}
		
	}
	
	// ����energy,state,rand�ֶ�(����С�ڵ���0 ȫ��energyΪ0��stateΪ������srandΪ2);
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
				
				pstem.setString(1, "(�ѿ�)");
				pstem.setInt(2, 0);
				pstem.setString(3, "����");
				pstem.setInt(4, 2);
				pstem.setInt(5,nid);
				pstem.setInt(6,tru);
				pstem.executeUpdate();
				//System.out.println("�Ѹ���Ϊ"+energy);
			}
			else{ continue;}
			
		}
		System.out.println("�������������Ѹ��µ���������������");
		
		pstem1.close();
		pstem.close();
		con.close();
	}
	

	// ����cid�ֶ�
	public void updateCid(int nid, int cid) throws Exception {
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql3);

		pstem.setInt(1, cid);
		pstem.setInt(2, nid);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
		
		
	}

	// ɾ�����е�ȫ����¼
	public void delete() throws Exception {
		String sql = "DELETE FROM trun";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.executeUpdate();
		
		pstem.close();
		con.close();
	}

	// ����ҵ������
	public void setBusi(String conNum, String busi) throws Exception {
		String sql = "UPDATE trun SET buis=? WHERE cid=?";
		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);

		int a = Integer.parseInt(conNum);
		String busi_=busi+"(�ܿ�)";

		pstem.setString(1, busi_);
		pstem.setInt(2, a);
		pstem.executeUpdate();
		System.out.println("�����ִα��buis�ֶ�");
		
		pstem.close();
		con.close();
	}
	/*//�ر�����
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

	// �����ִα�
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
