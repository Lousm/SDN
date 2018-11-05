package com.lou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lou.javabean.ChartTrun;
import com.lou.javabean.TrunNode;
import com.lou.test.Conn;

public class ChartDao {

	public List<ChartTrun> getNode(String number) throws Exception {
		Connection con = Conn.getConnection();
		String sql = "SELECT * FROM trun WHERE tru=?";
		PreparedStatement pstem = con.prepareStatement(sql);

		pstem.setString(1, number);
		ResultSet rs = pstem.executeQuery();

		List<ChartTrun> result = new ArrayList<ChartTrun>();
		while (rs.next()) {
			ChartTrun temp = new ChartTrun();

			temp.setXcoord(rs.getInt(2));
			temp.setYcoord(rs.getInt(3));

			temp.setSrand(rs.getInt(8));
			result.add(temp);
		}

		return result;
	}

}
