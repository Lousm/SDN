package com.lou.jstl;

import java.util.List;

import com.lou.dao.BusiDao;
import com.lou.javabean.BusiBean;
import com.lou.javabean.TrunNode;

public class Busi {
	public List<BusiBean> getNode() throws Exception {
		BusiDao busi = new BusiDao();
		return busi.getNode();
	}
}
