package com.lou.jstl;

import java.util.ArrayList;
import java.util.List;

import com.lou.dao.NodeDao;
import com.lou.javabean.TrunNode;

public class Node {
	public List<TrunNode> getNode(String number) throws Exception {
		NodeDao node = new NodeDao();
		return node.getNode(number);
	}
}
