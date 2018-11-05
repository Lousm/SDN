package com.lou.jstl;

import java.util.List;

import com.lou.dao.ChartDao;
import com.lou.dao.NodeDao;
import com.lou.javabean.ChartTrun;
import com.lou.javabean.TrunNode;

public class Chart {
	public List<ChartTrun> getNode(String number) throws Exception {
		ChartDao chart = new ChartDao();
		return chart.getNode(number);
	}

}
