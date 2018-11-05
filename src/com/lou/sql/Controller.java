package com.lou.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;

//生成控制器信息类
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
		// 控制坐标
		// 调用方法为控制器各个属性赋值
		userbean.setCnumber(set.Cnumber());
		userbean.setCradius(set.Cradius());
		userbean.setCxcoord(set.Cxcoord(cx));
		userbean.setCycoord(set.Cycoord(cy));

		// ResultSet rs
		// =con.createStatement().executeQuery("select * from controller");

		// 得到控制器各个属性赋值给sql语句
		// pstem.setInt(1, rs.getRow()+1);
		pstem.setInt(1, userbean.getCxcoord());
		pstem.setInt(2, userbean.getCycoord());
		pstem.setInt(3, userbean.getCradius());
		// System.out.println(sql);
		// 执行sql语句
		pstem.executeUpdate();
		
		pstem.close();
		con.close();

	}

	// 删除表中的全部记录
	public void delete() throws Exception {
		String sql = "DELETE FROM controller";
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

	// 向表中添加记录
	public void Cadd(int Camount) throws Exception {
		/*
		 * 添加控制器的数量，根据前台输入来控制！
		 * 
		 * 暂时测试~
		 */
		// int a = 3;//此参数应从jsp中获得
		/*
		 * for(int i=1;i<=a;i++){ info(); System.out.println("正在创建第 "+i+" 条数据");
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

	// 删除表中的全部记录
	public void CdelAll() throws Exception {
		delete();
	}

	/*
	 * 由此方法从ControllerServlet获取控制器数量生成控制器 然后，再根据控制器数量来生成节点（调用节点类的生成方法）
	 */
	// 生成控制器
	public void contor(int Camount) throws Exception {
		CdelAll();
		setkey();
		Cadd(Camount);

		// 调用节点生成方法
		node.node((Camount * 30));

		// 调用距离表生成方法
		dis.dist();

		// 调用生成轮次表的方法
		contr.tr();

		// 调用生产业务表的方法
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
