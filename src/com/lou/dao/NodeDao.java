package com.lou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lou.javabean.TrunNode;
import com.lou.test.Conn;

public class NodeDao {
	public List<TrunNode> getNode(String number) throws Exception {
		Connection con = Conn.getConnection();
		String sql = "select * from trun where tru = ?";
		PreparedStatement pstem = con.prepareStatement(sql);
		pstem.setString(1, number);
		ResultSet rs = pstem.executeQuery();
		List<TrunNode> result = new ArrayList<TrunNode>();
		while (rs.next()) {
			TrunNode temp = new TrunNode();
			temp.setNid(rs.getInt(1));
			temp.setXcoord(rs.getInt(2));
			temp.setYcoord(rs.getInt(3));
			temp.setBuis(rs.getString(4));
			temp.setTru(rs.getInt(5));
			temp.setEnergy(rs.getInt(6));
			temp.setState(rs.getString(7));
			temp.setSrand(rs.getInt(8));
			result.add(temp);
		}
		return result;
	}
}
