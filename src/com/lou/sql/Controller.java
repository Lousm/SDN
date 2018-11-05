package com.lou.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;

//���ɿ�������Ϣ��
public class Controller {

	UserBean userbean = new UserBean();
	Set set = new Set();
	Node node = new Node();
	Distance dis = new Distance();
	Business busi = new Business();
	ControlTrun contr = new ControlTrun();
	private static String sql = "INSERT INTO controller(xcoord,ycoord,radius) VALUES (?,?,?)";

	public void info(int cx, int cy) throws Exception {

		Connection con = Conn.getConnection();
		PreparedStatement pstem = con.prepareStatement(sql);
		// ��������
		// ���÷���Ϊ�������������Ը�ֵ
		userbean.setCnumber(set.Cnumber());
		userbean.setCradius(set.Cradius());
		userbean.setCxcoord(set.Cxcoord(cx));
		userbean.setCycoord(set.Cycoord(cy));

		// ResultSet rs
		// =con.createStatement().executeQuery("select * from controller");

		// �õ��������������Ը�ֵ��sql���
		// pstem.setInt(1, rs.getRow()+1);
		pstem.setInt(1, userbean.getCxcoord());
		pstem.setInt(2, userbean.getCycoord());
		pstem.setInt(3, userbean.getCradius());
		// System.out.println(sql);
		// ִ��sql���
		pstem.executeUpdate();
		
		pstem.close();
		con.close();

	}

	// ɾ�����е�ȫ����¼
	public void delete() throws Exception {
		String sql = "DELETE FROM controller";
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
		String sql1 = "ALTER  TABLE controller DROP number";
		String sql2 = "ALTER  TABLE controller ADD number INT(8) NOT NULL  FIRST";
		String sql3 = "ALTER  TABLE controller MODIFY COLUMN  number INT(8) NOT NULL  AUTO_INCREMENT,ADD PRIMARY  KEY(number)";
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
	public void Cadd(int Camount) throws Exception {
		/*
		 * ��ӿ�����������������ǰ̨���������ƣ�
		 * 
		 * ��ʱ����~
		 */
		// int a = 3;//�˲���Ӧ��jsp�л��
		/*
		 * for(int i=1;i<=a;i++){ info(); System.out.println("���ڴ����� "+i+" ������");
		 * }
		 */

		switch (Camount) {
		case 1:
			info(150, 150);
			break;
		case 2:
			info(150, 150);
			info(600, 150);
			break;
		case 3:
			info(150, 150);
			info(600, 150);
			info(150, 450);
			break;
		case 4:
			info(150, 150);
			info(600, 150);
			info(150, 450);
			info(600, 450);
			break;
		default:
			break;
		}
	}

	// ɾ�����е�ȫ����¼
	public void CdelAll() throws Exception {
		delete();
	}

	/*
	 * �ɴ˷�����ControllerServlet��ȡ�������������ɿ����� Ȼ���ٸ��ݿ��������������ɽڵ㣨���ýڵ�������ɷ�����
	 */
	// ���ɿ�����
	public void contor(int Camount) throws Exception {
		CdelAll();
		setkey();
		Cadd(Camount);

		// ���ýڵ����ɷ���
		node.node((Camount * 30));

		// ���þ�������ɷ���
		dis.dist();

		// ���������ִα�ķ���
		contr.tr();

		// ��������ҵ���ķ���
		busi.busi();

	}

	/*
	 * @Test public void fun1() throws Exception{ Cadd(); }
	 */
	@Test
	public void fun2() throws Exception {
		CdelAll();
		setkey();
		Cadd(4);
	}
	
	@Test
	public void fun3() throws Exception {
		contor(4);
	}

}
