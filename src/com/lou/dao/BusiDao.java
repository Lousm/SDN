package com.lou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lou.javabean.BusiBean;
import com.lou.javabean.TrunNode;
import com.lou.test.Conn;

public class BusiDao {
	public List<BusiBean> getNode() throws Exception {
		Connection con = Conn.getConnection();
		String sql = "select * from business";
		PreparedStatement pstem = con.prepareStatement(sql);

		ResultSet rs = pstem.executeQuery();
		List<BusiBean> result = new ArrayList<BusiBean>();
		while (rs.next()) {
			BusiBean temp = new BusiBean();
			temp.setNid(rs.getInt(1));
			temp.setCid(rs.getInt(2));
			temp.setBuis(rs.getString(3));

			result.add(temp);
		}
		return result;
	}
}
